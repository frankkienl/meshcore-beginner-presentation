package utils

import java.awt.AlphaComposite
import java.awt.Graphics2D
import java.awt.Rectangle
import java.awt.image.BufferedImage
import java.io.ByteArrayInputStream
import javax.imageio.ImageIO
import javax.imageio.ImageReader
import javax.imageio.metadata.IIOMetadataNode
import javax.imageio.stream.MemoryCacheImageInputStream

actual fun getGifDecoder(): GifDecoder = JvmGifDecoder()

class JvmGifDecoder : GifDecoder {

    override fun decode(bytes: ByteArray): GifAnimation {
        // Turn ByteArray into an InputStream
        ByteArrayInputStream(bytes).use { byteStream ->
            // Memory Cache, as we don't want a (temporary) file
            MemoryCacheImageInputStream(byteStream).use { imageInput ->
                // Find the Java Gif ImageReader
                val readers = ImageIO.getImageReadersByFormatName("gif")
                var reader: ImageReader? = null
                if (readers.hasNext()) {
                    // Pick the first available GIF ImageReader
                    reader = readers.next()
                } else {
                    // There are no ImageReader's at all
                    error("No GIF ImageIO reader available")
                }

                try {
                    reader.input = imageInput //Set the ImageInputStream (Memory Cached)

                    // Get metadata to find out width and height (LogicalScreen)
                    // May be null; In that case, the width & height of the first frame is used as Canvas size.
                    val streamMetadata = reader.streamMetadata
                    val logicalScreen = streamMetadata?.readLogicalScreenDescriptor()

                    val frameCount = reader.getNumImages(true)
                    require(frameCount > 0) { "GIF does not contain any frames" }

                    val firstFrame = reader.read(0)
                    val canvasWidth = logicalScreen?.width ?: firstFrame.width
                    val canvasHeight = logicalScreen?.height ?: firstFrame.height

                    val canvas = BufferedImage(canvasWidth, canvasHeight, BufferedImage.TYPE_INT_ARGB)
                    val frames = ArrayList<GifFrame>(frameCount)

                    var previousCanvas: BufferedImage? = null

                    for (index in 0 until frameCount) {
                        val metadata = reader.readFrameMetadata(index)
                        val rawFrame = if (index == 0) firstFrame else reader.read(index)
                        val frameImage = rawFrame.toArgbImage()

                        if (metadata.disposalMethod == DisposalMethod.RESTORE_TO_PREVIOUS) {
                            previousCanvas = canvas.deepCopy()
                        }

                        val graphics = canvas.createGraphics()
                        try {
                            graphics.composite = AlphaComposite.SrcOver
                            graphics.drawImage(frameImage, metadata.left, metadata.top, null)
                        } finally {
                            graphics.dispose()
                        }

                        // Add decoded frame to the animation
                        frames += canvas.toGifFrame(metadata.delayMillis)

                        // Do preparations for next frame, when dependent on previous frame.
                        when (metadata.disposalMethod) {
                            DisposalMethod.NONE,
                            DisposalMethod.DO_NOT_DISPOSE,
                                -> {
                                // Keep the current canvas as-is for the next frame.
                            }

                            DisposalMethod.RESTORE_TO_BACKGROUND -> {
                                canvas.clear(metadata.bounds)
                            }

                            DisposalMethod.RESTORE_TO_PREVIOUS -> {
                                val previous = previousCanvas
                                if (previous != null) {
                                    val restoreGraphics = canvas.createGraphics()
                                    try {
                                        restoreGraphics.composite = AlphaComposite.Src
                                        restoreGraphics.drawImage(previous, 0, 0, null)
                                    } finally {
                                        restoreGraphics.dispose()
                                    }
                                } else {
                                    canvas.clear(metadata.bounds)
                                }
                            }
                        }

                        previousCanvas = null
                    }

                    return GifAnimation(
                        width = canvasWidth,
                        height = canvasHeight,
                        frames = frames,
                    )
                } finally {
                    reader.dispose()
                }
            }
        }
    }

    private fun ImageReader.readFrameMetadata(frameIndex: Int): FrameMetadata {
        val metadata = getImageMetadata(frameIndex)
        val root = metadata.getAsTree(metadata.nativeMetadataFormatName) as IIOMetadataNode

        val imageDescriptor = root.findFirst("ImageDescriptor")
        val graphicControlExtension = root.findFirst("GraphicControlExtension")

        val left = imageDescriptor?.getIntAttribute("imageLeftPosition") ?: 0
        val top = imageDescriptor?.getIntAttribute("imageTopPosition") ?: 0
        val width = imageDescriptor?.getIntAttribute("imageWidth") ?: 0
        val height = imageDescriptor?.getIntAttribute("imageHeight") ?: 0

        val delayHundredths = graphicControlExtension?.getIntAttribute("delayTime") ?: 0
        val delayMillis = delayHundredths * 10

        val disposalMethod = when (graphicControlExtension?.getAttribute("disposalMethod")) {
            "doNotDispose" -> DisposalMethod.DO_NOT_DISPOSE
            "restoreToBackgroundColor" -> DisposalMethod.RESTORE_TO_BACKGROUND
            "restoreToPrevious" -> DisposalMethod.RESTORE_TO_PREVIOUS
            else -> DisposalMethod.NONE
        }

        return FrameMetadata(
            left = left,
            top = top,
            width = width,
            height = height,
            delayMillis = delayMillis,
            disposalMethod = disposalMethod,
        )
    }

    private fun javax.imageio.metadata.IIOMetadata.readLogicalScreenDescriptor(): LogicalScreenDescriptor? {
        val nativeFormatName = nativeMetadataFormatName ?: return null
        val root = getAsTree(nativeFormatName) as? IIOMetadataNode ?: return null
        val descriptor = root.findFirst("LogicalScreenDescriptor") ?: return null

        return LogicalScreenDescriptor(
            width = descriptor.getIntAttribute("logicalScreenWidth") ?: return null,
            height = descriptor.getIntAttribute("logicalScreenHeight") ?: return null,
        )
    }

    private fun BufferedImage.toArgbImage(): BufferedImage {
        if (type == BufferedImage.TYPE_INT_ARGB) {
            return this
        }

        val converted = BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB)
        val graphics = converted.createGraphics()
        try {
            graphics.composite = AlphaComposite.Src
            graphics.drawImage(this, 0, 0, null)
        } finally {
            graphics.dispose()
        }

        return converted
    }

    private fun BufferedImage.toGifFrame(delayMillis: Int): GifFrame {
        val pixels = IntArray(width * height)

        getRGB(
            0,
            0,
            width,
            height,
            pixels,
            0,
            width,
        )

        return GifFrame(
            width = width,
            height = height,
            argb = pixels,
            delayMillis = delayMillis,
        )
    }

    private fun BufferedImage.clear(bounds: Rectangle) {
        val clipped = bounds.intersection(Rectangle(0, 0, width, height))
        if (clipped.isEmpty) {
            return
        }

        val graphics = createGraphics()
        try {
            graphics.composite = AlphaComposite.Clear
            graphics.fillRect(clipped.x, clipped.y, clipped.width, clipped.height)
        } finally {
            graphics.dispose()
        }
    }

    private fun BufferedImage.deepCopy(): BufferedImage {
        val copy = BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB)
        val graphics: Graphics2D = copy.createGraphics()
        try {
            graphics.composite = AlphaComposite.Src
            graphics.drawImage(this, 0, 0, null)
        } finally {
            graphics.dispose()
        }
        return copy
    }

    private fun IIOMetadataNode.findFirst(name: String): IIOMetadataNode? {
        if (nodeName == name) {
            return this
        }

        for (index in 0 until length) {
            val child = item(index)
            if (child is IIOMetadataNode) {
                val found = child.findFirst(name)
                if (found != null) {
                    return found
                }
            }
        }

        return null
    }

    private fun IIOMetadataNode.getIntAttribute(name: String): Int? {
        return getAttribute(name).toIntOrNull()
    }

    private data class LogicalScreenDescriptor(
        val width: Int,
        val height: Int,
    )

    private data class FrameMetadata(
        val left: Int,
        val top: Int,
        val width: Int,
        val height: Int,
        val delayMillis: Int,
        val disposalMethod: DisposalMethod,
    ) {
        val bounds: Rectangle get() = Rectangle(left, top, width, height)
    }

    private enum class DisposalMethod {
        NONE,
        DO_NOT_DISPOSE,
        RESTORE_TO_BACKGROUND,
        RESTORE_TO_PREVIOUS,
    }
}
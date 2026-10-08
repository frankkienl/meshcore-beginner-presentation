package utils

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asComposeImageBitmap
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import kotlinx.coroutines.isActive
import kotlinx.coroutines.delay
import meshcore_beginner_presentation.generated.resources.Res
import org.jetbrains.skia.Bitmap
import org.jetbrains.skia.ColorAlphaType
import org.jetbrains.skia.ColorType
import org.jetbrains.skia.ImageInfo
import kotlin.time.Duration.Companion.milliseconds

data class GifFrame(
    val width: Int,
    val height: Int,
    val argb: IntArray,
    val delayMillis: Int,
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || this::class != other::class) return false

        other as GifFrame

        if (width != other.width) return false
        if (height != other.height) return false
        if (delayMillis != other.delayMillis) return false
        if (!argb.contentEquals(other.argb)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = width
        result = 31 * result + height
        result = 31 * result + delayMillis
        result = 31 * result + argb.contentHashCode()
        return result
    }
}

data class GifAnimation(
    val width: Int,
    val height: Int,
    val frames: List<GifFrame>,
) {
    val isAnimated: Boolean get() = frames.size > 1
    val durationMillis: Int get() = frames.sumOf { it.delayMillis }
}

interface GifDecoder {
    fun decode(bytes: ByteArray): GifAnimation
}

expect fun getGifDecoder(): GifDecoder

@Composable
fun GifImage(
    painter: Painter,
    path: String,
    contentDescription: String?,
    modifier: Modifier = Modifier,
    contentScale: ContentScale = ContentScale.Fit
){
    var gifBytes by remember { mutableStateOf<ByteArray?>(null) }
    LaunchedEffect(path) {
        gifBytes = Res.readBytes(path)
    }
    if (gifBytes != null) {
        val gif = remember(gifBytes) {
            getGifDecoder().decode(gifBytes!!)
        }
        GifAnimation(
            animation = gif,
            contentDescription = contentDescription,
            modifier = modifier,
            contentScale = contentScale
        )
    } else {
        Image(
            painter = painter,
            modifier = modifier,
            contentDescription = contentDescription
        )
    }
}

@Composable
fun GifAnimation(
    animation: GifAnimation,
    contentDescription: String?,
    modifier: Modifier = Modifier,
    contentScale: ContentScale = ContentScale.Fit,
) {
    val bitmaps = remember(animation) {
        animation.frames.map { frame -> frame.toImageBitmap() }
    }

    var frameIndex by remember(animation) {
        mutableIntStateOf(0)
    }

    LaunchedEffect(animation) {
        frameIndex = 0

        if (animation.frames.size <= 1) {
            return@LaunchedEffect
        }

        while (isActive) {
            val frame = animation.frames[frameIndex]
            val delayMillis = frame.delayMillis.coerceAtLeast(10)

            delay(delayMillis.milliseconds)

            frameIndex = (frameIndex + 1) % animation.frames.size
        }
    }

    val bitmap = bitmaps.getOrNull(frameIndex) ?: return

    Image(
        bitmap = bitmap,
        contentDescription = contentDescription,
        modifier = modifier,
        contentScale = contentScale,
    )
}

private fun GifFrame.toImageBitmap(): ImageBitmap {
    val bitmap = Bitmap()

    val imageInfo = ImageInfo(
        width = width,
        height = height,
        colorType = ColorType.BGRA_8888,
        alphaType = ColorAlphaType.PREMUL,
    )

    val pixels = argb.toBgraByteArray()

    bitmap.allocPixels(imageInfo)
    bitmap.installPixels(pixels)

    return bitmap.asComposeImageBitmap()
}

private fun IntArray.toBgraByteArray(): ByteArray {
    val bytes = ByteArray(size * 4)

    forEachIndexed { index, color ->
        val byteIndex = index * 4

        val alpha = color ushr 24
        val red = color ushr 16
        val green = color ushr 8
        val blue = color

        bytes[byteIndex] = blue.toByte()
        bytes[byteIndex + 1] = green.toByte()
        bytes[byteIndex + 2] = red.toByte()
        bytes[byteIndex + 3] = alpha.toByte()
    }

    return bytes
}



/*

val gif = remember(bytes) {
    getGifDecoder().decode(bytes)
}

GifAnimation(
    animation = gif,
    contentDescription = "Animated GIF",
    modifier = Modifier.fillMaxWidth(),
)

 */
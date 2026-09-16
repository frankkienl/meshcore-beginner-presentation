import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import net.kodein.cup.Presentation
import net.kodein.cup.Slides
import net.kodein.cup.cupApplication
import net.kodein.cup.imgexp.imageExport
import net.kodein.cup.laser.laser
import net.kodein.cup.overview.overview
import net.kodein.cup.speaker.speakerWindow
import net.kodein.cup.speaker.windowManagement
import net.kodein.cup.widgets.material3.cupScaleDown
import org.kodein.emoji.compose.EmojiService
import slides.intro
import slides.todo


fun main() = cupApplication(
    // TODO: Change title
    title = "My Amazing Presentation!"
) {
    remember {
        // https://github.com/kosi-libs/Emoji.kt?tab=readme-ov-file#initializing-the-emoji-service
        EmojiService.initialize()
    }

    Presentation(
        slides = presentationSlides,
        configuration = {
            // TODO: Configure plugins
            windowManagement()
            laser()
            speakerWindow()
            imageExport()
            overview()
        }
    ) { slidesContent ->
        MaterialTheme(
            // TODO: Apply your theme
            colorScheme = darkColorScheme(),
            //colorScheme = lightColorScheme(),
            typography = MaterialTheme.typography.cupScaleDown()
        ) {
            Surface(
                modifier = Modifier
                    .matchParentSize()
            ) {
                slidesContent()
            }
        }
    }
}

// TODO: Write your own slides!
val presentationSlides = Slides(
    intro,
    todo
)

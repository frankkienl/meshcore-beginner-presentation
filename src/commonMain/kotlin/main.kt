import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
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
import org.kodein.emoji.compose.EmojiService
import slides.s01_intro
import slides.s02_whoami
import slides.s03_goals
import slides.s04_what
import slides.s05_example_situation
import slides.s06_mesh
import slides.todo

val presentationSlides = Slides(
    s01_intro,
    s02_whoami,
    s03_goals,
    s04_what,
    s05_example_situation,
    s06_mesh,
    todo
)


fun main() = cupApplication(
    title = "MeshCore workshop"
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
            },
        ) { slidesContent ->
            FrankkieMaterialTheme {
                Surface(
                    modifier = Modifier.matchParentSize(),
                    color = MaterialTheme.colorScheme.background,
                ) {
                    slidesContent()
                }
            }
        }

}
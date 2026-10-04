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
import slides.s07_how_radio
import slides.s08_radio_eu
import slides.s09_meshtastic
import slides.s10_workshop
import slides.s11_flashing
import slides.s11a_not_bad
import slides.s12_app
import slides.s13_app2
import slides.s14_app3
import slides.s15_sound_tip
import slides.s16_end
import slides.s17_repeater_management
import slides.s18_repeater_update
import slides.s19_home_assistant
import slides.s20_sdr
import slides.s21_end_fr
import slides.todo

val presentationSlides = Slides(
    s01_intro,
    s02_whoami,
    s03_goals,
    s04_what,
    s05_example_situation,
    s06_mesh,
    s07_how_radio,
    s08_radio_eu,
    s09_meshtastic,
    s10_workshop,
    s11_flashing,
    s11a_not_bad,
    s12_app,
    s13_app2,
    s14_app3,
    s15_sound_tip,
    s16_end,
    s17_repeater_management,
    s18_repeater_update,
    s19_home_assistant,
    s20_sdr,
    s21_end_fr
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
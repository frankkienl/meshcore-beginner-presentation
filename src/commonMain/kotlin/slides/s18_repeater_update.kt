package slides

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import meshcore_beginner_presentation.generated.resources.Res
import meshcore_beginner_presentation.generated.resources.meshapp_repeater_cli
import meshcore_beginner_presentation.generated.resources.meshapp_repeater_login
import meshcore_beginner_presentation.generated.resources.meshcore_logo
import meshcore_beginner_presentation.generated.resources.meshcoreio_web1
import meshcore_beginner_presentation.generated.resources.nrfdfu
import meshcore_beginner_presentation.generated.resources.repeater
import net.kodein.cup.Slide
import net.kodein.cup.speaker.SpeakerNotes
import net.kodein.cup.widgets.material3.BulletPoints
import org.jetbrains.compose.resources.painterResource

val s18_repeater_update by Slide(stepCount = 8, context = SpeakerNotes(
    listOf(
        0..0 to """
            Repeater Update  
            - USB  
            - Bluetooth  
            - Wifi  
        """.trimIndent(),
        1..1 to """
            Mention that Repeaters should be up high,
            nobody has 20m USB cable... right? OTA ftw!
        """.trimIndent(),
        2..3 to """
            This space has been left intentionally blank.
        """.trimIndent(),
        4..4 to """
            DFU packages can be downloaded from the web Flasher 
        """.trimIndent(),
        5..6 to """
            This space has been left intentionally blank.
        """.trimIndent(),
        7..7 to """
            ESP device make AP, connect to http://192.168.4.1/ and upload file.
        """.trimIndent()
    )
)) { stepIndex ->
    RepeaterUpdateSlide(stepIndex)
}

@Composable
fun RepeaterUpdateSlide(stepIndex: Int) {
    Row(Modifier.fillMaxSize()) {
        Column(Modifier.weight(1f)) {
            Spacer(Modifier.height(24.dp))
            Text("Repeater Update", style = MaterialTheme.typography.headlineMediumEmphasized)
            Spacer(Modifier.height(16.dp))
            BulletPoints {
                item(stepIndex >= 1) {
                    Text("USB (web-flasher)")
                }
                item(stepIndex >= 2) {
                    Text("OTA - nRF - Bluetooth")
                }
            }
            Column(Modifier.padding(start = 32.dp)) {
                AnimatedVisibility(stepIndex >= 3) { Text(" - CLI") }
                AnimatedVisibility(stepIndex >= 4) { Text(" - DFU") }
            }
            BulletPoints {
                item(stepIndex >=5) {
                    Text("OTA - ESP -  WiFi")
                }
            }
            Column(Modifier.padding(start = 32.dp)) {
                AnimatedVisibility(stepIndex >= 6) { Text(" - CLI") }
                AnimatedVisibility(stepIndex >= 7) { Text(" - Web") }
            }

        }
        Spacer(Modifier.width(16.dp))
        Column(Modifier.widthIn(150.dp, max = 200.dp).fillMaxHeight()) {
            val currentImageRes = when (stepIndex) {
                0 -> Res.drawable.repeater
                1 -> Res.drawable.meshcoreio_web1
                2 -> Res.drawable.meshapp_repeater_login
                3 -> Res.drawable.meshapp_repeater_cli
                4 -> Res.drawable.nrfdfu
                5 -> Res.drawable.repeater
                6 -> Res.drawable.meshapp_repeater_cli
                7 -> Res.drawable.repeater
                else -> Res.drawable.meshcore_logo
            }
            val subtitle = when (stepIndex) {
                0 -> "A repeater device"
                1 -> "Flash via web flasher"
                2 -> "Login over Mesh"
                3 -> "Settings CLI"
                4 -> "nRF DFU app"
                5 -> "A repeater device"
                6 -> "Settings CLI"
                7 -> "A repeater device"
                else -> ""
            }
            Image(
                painterResource(currentImageRes),
                contentDescription = "MeshCore app",
                modifier = Modifier.weight(1f)
            )
            Spacer(Modifier.height(8.dp))
            Text(subtitle, style = MaterialTheme.typography.bodySmall)
            Spacer(Modifier.height(8.dp))
        }
    }
}

@Composable
@Preview
fun PreviewRepeaterUpdate() {
    RepeaterUpdateSlide(0)
}
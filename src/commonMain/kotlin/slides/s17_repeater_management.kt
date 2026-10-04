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
import meshcore_beginner_presentation.generated.resources.meshapp_main
import meshcore_beginner_presentation.generated.resources.meshapp_repeater_login
import meshcore_beginner_presentation.generated.resources.meshapp_repeater_main
import meshcore_beginner_presentation.generated.resources.meshapp_repeater_settings1
import meshcore_beginner_presentation.generated.resources.meshapp_repeater_settings2
import meshcore_beginner_presentation.generated.resources.meshapp_repeater_settings3
import meshcore_beginner_presentation.generated.resources.meshapp_repeater_start
import meshcore_beginner_presentation.generated.resources.meshcore_logo
import meshcore_beginner_presentation.generated.resources.repeater
import net.kodein.cup.Slide
import net.kodein.cup.speaker.SpeakerNotes
import net.kodein.cup.widgets.material3.BulletPoints
import org.jetbrains.compose.resources.painterResource

val s17_repeater_management by Slide(
    stepCount = 8, context = SpeakerNotes(
        listOf(
            0..0 to """
                Note: repeater devices may look different
            """.trimIndent(),
            1..1 to """
                We assume the repeater is already a contact.
                If not. We need to hear the "advertisement" first.
                This can take many hours. Do this when setting up the repeater!
                It probably advertises on reboot. 
            """.trimIndent(),
            2..2 to """
                Password should have been setup already.              
            """.trimIndent(),
            3..3 to """
                Talk about not using too much traffic on the mesh network
            """.trimIndent(),
            5..5 to """
                Repeater name ... just it however. 
                
                No need for NL-RTD-Pixelbar
            """.trimIndent(),
            6..6 to """
                Mention owner-info, advertisement interval, location
            """.trimIndent(),
            7..7 to """
                Mention regions, but it's outside of the scope of this BEGINNER workshop.
            """.trimIndent()
        )
    )
) { stepIndex ->
    RepeaterManagementSlide(stepIndex)
}


@Composable
fun RepeaterManagementSlide(stepIndex: Int) {
    Row(Modifier.fillMaxSize()) {
        Column(Modifier.weight(1f)) {
            Spacer(Modifier.height(24.dp))
            Text("Repeater Management", style = MaterialTheme.typography.headlineMediumEmphasized)
            Spacer(Modifier.height(16.dp))
            BulletPoints {
                item(stepIndex >= 1) {
                    Text("Connect")
                }
                item(stepIndex >= 2) {
                    Text("Login")
                }
                item(stepIndex >= 3) {
                    Text("Check status")
                }
                item(stepIndex >= 5) {
                    Text("Settings")
                }
            }
            Column(Modifier.padding(start = 32.dp)) {
                AnimatedVisibility(stepIndex >= 5) { Text(" - Name") }
                AnimatedVisibility(stepIndex >= 6) { Text(" - Advertise, Location") }
                AnimatedVisibility(stepIndex >= 7) { Text(" - Regions") }
            }
        }
        Spacer(Modifier.width(16.dp))
        Column(Modifier.widthIn(150.dp, max = 200.dp).fillMaxHeight()) {
            val currentImageRes = when (stepIndex) {
                0 -> Res.drawable.repeater
                1 -> Res.drawable.meshapp_main
                2 -> Res.drawable.meshapp_repeater_login
                3 -> Res.drawable.meshapp_repeater_start
                4 -> Res.drawable.meshapp_repeater_main
                5 -> Res.drawable.meshapp_repeater_settings1
                6 -> Res.drawable.meshapp_repeater_settings2
                7 -> Res.drawable.meshapp_repeater_settings3
                else -> Res.drawable.meshcore_logo
            }
            val subtitle = when (stepIndex) {
                0 -> "A repeater device"
                1 -> "Repeater in contacts"
                2 -> "Login over Mesh"
                3 -> "Initial screen"
                4 -> "Main screen"
                5 -> "Settings (1)"
                6 -> "Settings (2)"
                7 -> "Settings (3)"
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
fun PreviewRepeaterManagementSlide() {
    RepeaterManagementSlide(0)
}

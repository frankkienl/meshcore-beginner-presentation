package slides

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import meshcore_beginner_presentation.generated.resources.Res
import meshcore_beginner_presentation.generated.resources.ha_meshcore
import meshcore_beginner_presentation.generated.resources.home_assistant
import meshcore_beginner_presentation.generated.resources.meshcore_logo
import meshcore_beginner_presentation.generated.resources.meshcoreio_web3
import net.kodein.cup.Slide
import net.kodein.cup.speaker.SpeakerNotes
import net.kodein.cup.widgets.material3.BulletPoints
import org.jetbrains.compose.resources.painterResource

val s19_home_assistant by Slide(
    stepCount = 3,
    context = SpeakerNotes(listOf(
        0..0 to """
            **Home Assistant integration**          
            - Companion USB
            - Integration
        """.trimIndent(),
        1..1 to """
            User needs to flash `Companion USB` firmware;  
            And connect node to the device running Home Assistant via USB
        """.trimIndent(),
        2..2 to """
            Screenshot of Home Assistant integration
        """.trimIndent()
    ))
    ) { stepIndex ->
    SlideHomeAssistant(stepIndex)
}

@Composable
fun SlideHomeAssistant(stepIndex : Int) {
    Row(Modifier.fillMaxSize()) {
        Column(Modifier.weight(1f)) {
            Spacer(Modifier.height(24.dp))
            Text("Home Assistant", style = MaterialTheme.typography.headlineMediumEmphasized)
            Spacer(Modifier.height(16.dp))
            BulletPoints {
                item(stepIndex >= 1) {
                    Text("Companion USB")
                }
                item(stepIndex >= 2) {
                    Text("Integration")
                }
            }
        }
        Spacer(Modifier.width(16.dp))
        Column(Modifier.widthIn(150.dp, max = 300.dp).fillMaxHeight()) {
            val currentImageRes = when (stepIndex) {
                0 -> Res.drawable.home_assistant
                1 -> Res.drawable.meshcoreio_web3
                2 -> Res.drawable.ha_meshcore

                else -> Res.drawable.meshcore_logo
            }
            val subtitle = when (stepIndex) {
                0 -> "Home Assistant"
                1 -> "Flash via web flasher"
                2 -> "Integration"
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
fun PreviewSlideHomeAssistant() {
    SlideHomeAssistant(0)
}
package slides

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import meshcore_beginner_presentation.generated.resources.meshcore_logo
import meshcore_beginner_presentation.generated.resources.meshcoreio_web1
import meshcore_beginner_presentation.generated.resources.meshcoreio_web2
import meshcore_beginner_presentation.generated.resources.meshcoreio_web3
import meshcore_beginner_presentation.generated.resources.meshcoreio_web4
import meshcore_beginner_presentation.generated.resources.meshcoreio_web_tty
import net.kodein.cup.Slide
import net.kodein.cup.widgets.material3.BulletPoints
import org.jetbrains.compose.resources.painterResource

val s11_flashing by Slide(stepCount = 6) { stepIndex ->
    FlashingSlide(stepIndex)
}

@Composable
fun FlashingSlide(stepIndex: Int) {
    Box(Modifier.fillMaxSize().padding(vertical = 24.dp)) {
        Row(Modifier.fillMaxSize()) {
            Column {
                Text("Flashing WisMesh Tag", style = MaterialTheme.typography.bodyLargeEmphasized)
                Spacer(Modifier.height(32.dp))
                Column {
                    AnimatedVisibility(stepIndex >= 0) {
                        Text("https://meshcore.io/", style = MaterialTheme.typography.bodySmall)
                        Spacer(Modifier.height(32.dp))
                    }
                    AnimatedVisibility(stepIndex >= 1) {
                        Text("Select 'RAK WisMesh Tag'", style = MaterialTheme.typography.bodySmall)
                        Spacer(Modifier.height(32.dp))
                    }
                    AnimatedVisibility(stepIndex >= 2) {
                        Text("Select 'Companion Bluetooth'", style = MaterialTheme.typography.bodySmall)
                        Spacer(Modifier.height(32.dp))
                    }
                    AnimatedVisibility(stepIndex >= 3) {
                        Text("Enter DFU; Select 'ttyACM0'", style = MaterialTheme.typography.bodySmall)
                        Spacer(Modifier.height(32.dp))
                    }
                    AnimatedVisibility(stepIndex >= 4) {
                        Text("First time: 'Erase Flash'", style = MaterialTheme.typography.bodySmall)
                        Spacer(Modifier.height(32.dp))
                    }
                    AnimatedVisibility(stepIndex >= 5) {
                        Text("Flash!", style = MaterialTheme.typography.bodySmall)
                    }
                }
            }

            Spacer(Modifier.width(8.dp))

            Column(Modifier.fillMaxHeight(),
                verticalArrangement = Arrangement.Center) {
                val currentImageRes = when (stepIndex) {
                    0 -> Res.drawable.meshcoreio_web1
                    1 -> Res.drawable.meshcoreio_web2
                    2 -> Res.drawable.meshcoreio_web3
                    3 -> Res.drawable.meshcoreio_web_tty
                    4 -> Res.drawable.meshcoreio_web4
                    5 -> Res.drawable.meshcoreio_web4
                    else -> Res.drawable.meshcore_logo
                }
                val subtitle = when (stepIndex) {
                    0 -> "Use a Chromium based browser\nClick 'Flasher'"
                    1 -> "You can use the search-box"
                    2 -> "The role for the device"
                    3 -> "ttyACM on Linux/Mac; COM on Windows"
                    4 -> "Clear old firmware's flash storage"
                    5 -> "You are done after this!"
                    else -> ""
                }
                Image(
                    painterResource(currentImageRes),
                    contentDescription = "MeshCore workshop",
                    modifier = Modifier.widthIn(min = 50.dp, max = 300.dp)
                )
                Spacer(Modifier.height(8.dp))
                Text(subtitle, style = MaterialTheme.typography.bodySmall)

            }
        }
    }
}


@Composable
@Preview
fun PreviewFlashingSlide() {
    FlashingSlide(0)
}
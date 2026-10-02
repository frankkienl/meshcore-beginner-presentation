package slides

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import meshcore_beginner_presentation.generated.resources.Res
import meshcore_beginner_presentation.generated.resources.meshtastic
import meshcore_beginner_presentation.generated.resources.xkcd
import net.kodein.cup.Slide
import org.jetbrains.compose.resources.painterResource

val s09_meshtastic by Slide {
    MeshtasticSlide()
}

@Composable
fun MeshtasticSlide() {
    Box(Modifier.fillMaxWidth()) {
        Column {
            Row(Modifier.fillMaxWidth()) {
                Column(
                    Modifier.weight(1f),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Spacer(Modifier.height(32.dp))
                    Text(
                        "MeshCore\nvs\nMeshtastic",
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.bodyLargeEmphasized
                    )
                }
                Spacer(Modifier.width(8.dp))
                Image(
                    painterResource(Res.drawable.xkcd),
                    modifier = Modifier.height(150.dp),
                    contentDescription = "XKCD"
                )
            }
            Spacer(Modifier.height(8.dp))
            Row(Modifier.fillMaxWidth()) {
                Image(
                    painterResource(Res.drawable.meshtastic),
                    modifier = Modifier.height(128.dp),
                    contentDescription = "Meshtastic"
                )
                Spacer(Modifier.width(8.dp))
                Column {
                    Text("Meshtastic cons", style = MaterialTheme.typography.bodyLargeEmphasized)
                    Text("Open source drama", style = MaterialTheme.typography.bodySmall)
                    Text("Default hop limit of 3 (up to 7)", style = MaterialTheme.typography.bodySmall)
                    Text("Client repeaters", style = MaterialTheme.typography.bodySmall)
                    Text("Relies on MQTT (internet)", style = MaterialTheme.typography.bodySmall)
                    Text("No incentive to create coverage", style = MaterialTheme.typography.bodySmall)
                }
            }
        }
    }
}


@Composable
@Preview
fun PreviewMeshtasticSlide() {
    MeshtasticSlide()
}


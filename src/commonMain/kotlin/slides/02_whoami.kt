package slides

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import meshcore_beginner_presentation.generated.resources.Res
import meshcore_beginner_presentation.generated.resources.frankkie
import meshcore_beginner_presentation.generated.resources.meshcore_logo
import meshcore_beginner_presentation.generated.resources.pixelbar
import net.kodein.cup.Slide
import net.kodein.cup.speaker.SpeakerNotes
import org.jetbrains.compose.resources.painterResource

val s02_whoami by Slide(
    context = SpeakerNotes(
        """
            Keep it short, nobody cares.  
            Mention other the speakers, the real experts.
        """.trimIndent()
    )
) {
    WhoamiSlide()
}

@Composable
fun WhoamiSlide() {
    Box(
        modifier = Modifier.fillMaxWidth()
    ) {
        Row {
            Spacer(Modifier.weight(0.1f))
            Image(
                painterResource(Res.drawable.frankkie),
                modifier = Modifier.width(100.dp),
                contentDescription = "Frankkie"
            )
        }
        Column(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = "Who am I",
                style = MaterialTheme.typography.headlineMedium
            )

            Text(text = "Frank \"FrankkieNL\" Bouwens")
            Text("Software developer; Android apps")
            Text("Member at Pixelbar Rotterdam")
            Text("MeshCore user (not an expert)")

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painterResource(Res.drawable.pixelbar),
                    modifier = Modifier.width(200.dp),
                    contentDescription = "pixelbar"
                )
                Spacer(
                    modifier = Modifier.weight(0.1f).widthIn(100.dp)
                )
                Image(
                    painterResource(Res.drawable.meshcore_logo),
                    modifier = Modifier.width(250.dp),
                    contentDescription = "meshcore"
                )
            }
        }
    }
}

@Composable
@Preview
fun PreviewWhoamiSlide() {
    WhoamiSlide()
}
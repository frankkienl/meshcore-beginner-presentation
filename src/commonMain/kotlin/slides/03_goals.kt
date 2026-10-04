package slides

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import meshcore_beginner_presentation.generated.resources.devices
import meshcore_beginner_presentation.generated.resources.goal
import net.kodein.cup.Slide
import net.kodein.cup.speaker.SpeakerNotes
import org.jetbrains.compose.resources.painterResource

val s03_goals by Slide(
    context = SpeakerNotes("""
        Table of contents
    """.trimIndent())
) {
    GoalsSlide()
}

@Composable
fun GoalsSlide() {
    Box(modifier = Modifier.fillMaxWidth()) {
        Row {
            Column {
                Spacer(modifier = Modifier.height(32.dp))
                Text("Goals of this workshop",
                    style = MaterialTheme.typography.headlineMedium)
                Text("1) Flashing the WisMesh Tag")
                Text("2) Settings (preset)")
                Text("3) Join the #test channel")
                Text("4) Sending messages")
                Spacer(modifier = Modifier.height(32.dp))
                Text("But first...")
                Text("Some general information")
            }
            Spacer(Modifier.weight(0.1f))
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Image(
                    painterResource(Res.drawable.devices),
                    modifier = Modifier.width(150.dp),
                    contentDescription = "Devices"
                )
                Spacer(Modifier.weight(0.1f))
                Image(
                    painterResource(Res.drawable.goal),
                    modifier = Modifier.width(200.dp),
                    contentDescription = "Goals"
                )
            }
        }
    }
}

@Composable
@Preview
fun PreviewGoalsSlide() {
    GoalsSlide()
}
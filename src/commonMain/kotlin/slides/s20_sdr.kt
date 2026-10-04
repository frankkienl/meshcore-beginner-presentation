package slides

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import meshcore_beginner_presentation.generated.resources.Res
import meshcore_beginner_presentation.generated.resources.rtl_sdr
import net.kodein.cup.Slide
import net.kodein.cup.speaker.SpeakerNotes
import org.jetbrains.compose.resources.painterResource

val s20_sdr by Slide(context = SpeakerNotes("""
    Whip out the SDR, if you didn't forget to bring it this time!!
    Otherwise, mention the other speakers, who are experts on in this area ;-)
""".trimIndent())) {
    SdrSlide()
}

@Composable
fun SdrSlide() {
    Row(Modifier.fillMaxSize()) {
        Column(Modifier.weight(1f)) {
            Spacer(Modifier.height(24.dp))
            Text("SDR", style = MaterialTheme.typography.headlineMediumEmphasized)
            Spacer(Modifier.height(16.dp))
            Text("An SDR can make radio waves visual")
        }
        Column(
            Modifier.fillMaxHeight(),
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painterResource(Res.drawable.rtl_sdr),
                contentDescription = "RTL SDR"
            )
            Text("RTL SDR device")
        }
    }
}

@Composable
@Preview
fun PreviewSdrSlide() {
    SdrSlide()
}
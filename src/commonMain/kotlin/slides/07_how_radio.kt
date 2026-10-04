package slides

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import meshcore_beginner_presentation.generated.resources.Res
import meshcore_beginner_presentation.generated.resources.radio_spectrum
import meshcore_beginner_presentation.generated.resources.radio_spectrum2
import net.kodein.cup.Slide
import net.kodein.cup.speaker.SpeakerNotes
import org.jetbrains.compose.resources.painterResource

val s07_how_radio by Slide(
    context = SpeakerNotes("""
        We all know about Radio waves, and use them daily without realizing it.
        WiFi, Bluetooth; For the Smarthome users, probably Zigbee or Thread too.
        Used a smartphone? You’ve connected to 2G/3G/4G/5G cell towers.
    """.trimIndent()
    )
) {
    HowRadioSlide()
}

@Composable
fun HowRadioSlide() {
    Box(Modifier.fillMaxWidth()) {
        Column {
            Text(
                "A little more detail about the 'How'",
                style = MaterialTheme.typography.headlineMedium
            )

            Row {
                Column {
                    val texts = listOf(
                        "Radio waves",
                        "Invisible",
                        "Can go through walls",
                        "Can travel over distance",
                        "Higher frequency = ",
                        "Higher data rate /",
                        "Lower distance"
                    )
                    texts.forEach {
                        Text(it)
                    }
                }
                Spacer(Modifier.width(8.dp))
                Column {
                    Image(
                        painterResource(Res.drawable.radio_spectrum2),
                        contentDescription = "Radio spectrum2"
                    )
                    Image(
                        painterResource(Res.drawable.radio_spectrum),
                        contentDescription = "Radio spectrum1"
                    )
                }
            }
        }
    }
}

@Composable
@Preview
fun PreviewHowRadioSlide() {
    HowRadioSlide()
}
package slides

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import meshcore_beginner_presentation.generated.resources.Res
import meshcore_beginner_presentation.generated.resources.eu
import net.kodein.cup.Slide
import net.kodein.cup.speaker.SpeakerNotes
import org.jetbrains.compose.resources.painterResource
import org.kodein.emoji.Emoji
import org.kodein.emoji.compose.m3.TextWithNotoAnimatedEmoji
import org.kodein.emoji.symbols.other_symbol.CheckBoxWithCheck
import org.kodein.emoji.symbols.other_symbol.CheckMark
import org.kodein.emoji.symbols.other_symbol.CheckMarkGreen

val s08_radio_eu by Slide(stepCount = 2, context = SpeakerNotes("""
    Fun fact: 
    Car-keys usually use 443 MHz

    Other frequencies are not to be used freely; 
    2G/3G/4G/5G frequencies are very expensive.

    2.4 GHz is technically free to use, but is already crowded with Bluetooth, WiFi, ESP-NOW, ( Zigbee ? )
    And the range is not enough for a communications system

    Bridges to convert messages from 443 to 868 exist; 
    But we recommend to just follow the crowd. 
    That’s why these meetups exist, to make sure everyone is on the same page!

    I haven’t found a source for the claim that the range is roughly the same; 
    This is just something I heard someone say during a previous Mesh[Core/Tastic] meetup.
""".trimIndent())) { stepIndex ->
    RadioEuSlide(stepIndex)
}

@Composable
fun RadioEuSlide(stepIndex: Int) {
    Box(Modifier.fillMaxSize()) {

        // EU Flag, right aligned
        Row(
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painterResource(Res.drawable.eu),
                contentDescription = "EU",
                modifier = Modifier.width(96.dp)
            )
        }

        Row {
            Column {
                Spacer(Modifier.height(24.dp))
                Text(
                    "EU, royalty-free frequencies",
                    style = MaterialTheme.typography.headlineMedium
                )
                Spacer(Modifier.height(16.dp))

                Text("444 MHz", style = MaterialTheme.typography.bodyLargeEmphasized)
                Text(
                    "Lower frequency, better through walls, longer distance, lower data-rate",
                    style = MaterialTheme.typography.bodySmall
                )
                Spacer(Modifier.height(8.dp))
                Text("868 MHz", style = MaterialTheme.typography.bodyLargeEmphasized)
                Text(
                    "Higher frequency, worse through walls, shorter distance, higher data-rate",
                    style = MaterialTheme.typography.bodySmall
                )
                Spacer(Modifier.height(8.dp))
                Text("MeshCore works on both", style = MaterialTheme.typography.bodyLargeEmphasized)
                TextWithNotoAnimatedEmoji("The local community picked 868 MHz ${Emoji.CheckMarkGreen}")
                Spacer(Modifier.height(8.dp))
                AnimatedVisibility(stepIndex > 0) {
                    Column {
                        Text("Preset for the Netherlands:")
                        Text("869.618 MHz, BW 62.5 kHz, SF 7, CR 5")
                        Text(
                            "Note: This preset changed in May, please update ASAP",
                            style = MaterialTheme.typography.bodySmall
                        )
                        Spacer(Modifier.height(16.dp))
                        Text(
                            "The wattage that amateurs are allowed to use for 868 MHz is higher than for 443 MHz;\n" +
                                    "Making the distance roughly the same, but still have the higher data-rate.\n" +
                                    "You need to use the same frequency to communicate.",
                            style = MaterialTheme.typography.bodySmall
                        )
                    }
                }
            }
        }

    }
}

@Composable
@Preview
fun PreviewRadioEuSlide() {
    RadioEuSlide(0)
}
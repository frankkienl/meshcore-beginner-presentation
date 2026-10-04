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
import net.kodein.cup.speaker.SpeakerNotes
import org.jetbrains.compose.resources.painterResource

val s09_meshtastic by Slide(context = SpeakerNotes("""
    Competing standards, always fun. Especially when those are not compatible.
    With a system like this, for communication, you need consensus! 
    If you are not compatible, you can not participate. 
    Using a different frequency/preset/data-format? Have fun talking to yourself.

    Most of us started using Meshtastic about a year (or 2) ago.
    But quickly we found out about the following problems:
    PR’s were not accepted (open source, as in source available…)
    Not useful for big coverage, due to low hop limit
    Clients were also repeaters, making the hop limit extra low
    Reliance on MQTT; Nice to connect distant networks to each other, get a message 100’s of KM’s away with a single hop “teleport”. But this totally dis-incentivise people to create some actual coverage. You would only have some “blue spots”.  Also, what if the internet is down. So not useful as back-up at all.

    But Meshtastic was a good start; We thank them.
    We all learned a lot from it, like what *not* to do.
    And thanks to Meshtastic, these hardware devices exist.

    We’re not saying MeshCore is perfect in every way.
    But it’s the best system we have at the moment.
    Some people in the community are seeing problems now the mesh is getting bigger.

    One of the problems has to do with the paths, when a message passes through the mesh, every repeater add the first 2 symbols of their public key to the chain. But with only 2 characters, the number of collisions is high.
    My own repeater is one of the victims of this. A new protocol is in the works, to try to fix this.

    Another problem, that is currently being solved, is the fact that not everything is actually open-source.
    The protocol is, but the official smartphone app isn’t. An open source version is in the works. (Flutter)
    Not that people are complaining much, the closed-source app is fully functional without paying; (wait-time for repeater management)

    The Ripple firmware (T-Deck) is also closed source, and not very beginner friendly.
    For this, a community firmware is also in the works. (Payment for using the map, repeater management)

    We understand that a small payment for someone who’ve put in a lot of work is reasonable.
    It’s not really about the money, but with it being a privacy/freedom type projet, having an open-source option is very much appreciated.

""".trimIndent())) {
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


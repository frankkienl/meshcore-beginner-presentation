package slides

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import meshcore_beginner_presentation.generated.resources.Res
import meshcore_beginner_presentation.generated.resources.meshcore_logo
import net.kodein.cup.Slide
import net.kodein.cup.speaker.SpeakerNotes
import net.kodein.cup.widgets.material3.BulletPoints
import org.jetbrains.compose.resources.painterResource
import org.kodein.emoji.Emoji
import org.kodein.emoji.EmojiFinder
import org.kodein.emoji.compose.m3.TextWithNotoAnimatedEmoji
import org.kodein.emoji.people_body.hand_fingers_open.Wave
import org.kodein.emoji.smileys_emotion.face_hand.listFaceHand

val s16_end by Slide(stepCount = 5, context = SpeakerNotes("""
    Fake end! There's more! 
    If time allows, there's advanced topics:
    - Repeater management
    - HA integration
    - Antenna RF (actually SDR); ask the actual experts!
""".trimIndent())) { stepIndex ->
    EndSlide(stepIndex)
}

@Composable
fun EndSlide(stepIndex: Int) {
    Column {
        Text("That's the basics!", style = MaterialTheme.typography.headlineMediumEmphasized)
        Spacer(Modifier.height(24.dp))
        AnimatedVisibility(stepIndex == 0) {
            Column {
                Text("Questions?")
                Spacer(Modifier.height(32.dp))
                TextWithNotoAnimatedEmoji("${Emoji.Wave}", style = MaterialTheme.typography.headlineLargeEmphasized)
                Image(
                    painterResource(Res.drawable.meshcore_logo),
                    contentDescription = "MeshCore logo",
                    modifier = Modifier.width(240.dp)
                )
            }
        }
        AnimatedVisibility(stepIndex >= 1) {
            Column {
                Text("More advanced optics:")
                BulletPoints {
                    item(stepIndex >= 2) {
                        Text("Repeater Management")
                    }
                    item(stepIndex >= 3) {
                        Text("Home Assistant integration")
                    }
                    item(stepIndex >= 4) {
                        Text("Antenna / RF")
                    }
                }
            }
        }
    }
}

@Composable
@Preview
fun PreviewEndSlide() {
    EndSlide(0)
}
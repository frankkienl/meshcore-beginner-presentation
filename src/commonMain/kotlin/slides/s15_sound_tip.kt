package slides

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import meshcore_beginner_presentation.generated.resources.Res
import meshcore_beginner_presentation.generated.resources.audio
import meshcore_beginner_presentation.generated.resources.wismesh_tag
import net.kodein.cup.Slide
import net.kodein.cup.speaker.SpeakerNotes
import org.jetbrains.compose.resources.painterResource

val s15_sound_tip by Slide(stepCount = 2, context = SpeakerNotes("""
    Slide has 2 steps! in 2nd step, the audio icon is gone !!
    
    The SenseCAP Tracker will, by default, beep every time a message arrives. 
    For every channel, irregardless of being ‘mentioned’. 
    In the smartphone app, you can manage your notifications very well.
    But on the device itself, not so much. So I recommend you all to just turn of the beeps.

    Haven’t found any source online for this; 
    Heard this tip from someone else using MeshCore.
    But I know it works, tried it myself ;-)

""".trimIndent())) { stepIndex ->
    SoundTipSlide(stepIndex)
}


@Composable
fun SoundTipSlide(stepIndex: Int) {
    Box(Modifier.fillMaxSize().padding(top = 32.dp)) {
        Row(Modifier.fillMaxSize()) {
            Column(Modifier.weight(1f)) {
                Spacer(Modifier.height(24.dp))
                Text("Device tip", style = MaterialTheme.typography.headlineMediumEmphasized)
                Spacer(Modifier.height(16.dp))
                Text("Press button for 3 seconds to turn of the sound")
                Spacer(Modifier.height(8.dp))
                Text("Otherwise will beep for any received message, when not connected via Bluetooth")
            }

            Box(
                Modifier
                    .padding(16.dp)
                    .clip(MaterialTheme.shapes.medium)
                    .background(MaterialTheme.colorScheme.primary)
            ) {
                Image(
                    painterResource(Res.drawable.wismesh_tag),
                    contentDescription = "Wismesh Tag",
                    modifier = Modifier.padding(16.dp).widthIn(min = 64.dp, max = 120.dp)
                )
            }
            Column(Modifier.width(64.dp)) {
                Spacer(Modifier.height(64.dp))
                AnimatedVisibility(stepIndex == 0) {
                    Image(
                        painterResource(Res.drawable.audio),
                        contentDescription = "audio"
                    )
                }
            }
        }
    }
}

@Composable
@Preview
fun PreviewSoundTip() {
    SoundTipSlide(0)
}
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
import meshcore_beginner_presentation.generated.resources.meshcore_app_add_channel
import meshcore_beginner_presentation.generated.resources.meshcore_app_add_channel_test
import meshcore_beginner_presentation.generated.resources.meshcore_app_channel_test
import meshcore_beginner_presentation.generated.resources.meshcore_app_menu
import meshcore_beginner_presentation.generated.resources.meshcore_logo
import net.kodein.cup.Slide
import net.kodein.cup.speaker.SpeakerNotes
import org.jetbrains.compose.resources.painterResource

val s14_app3 by Slide(stepCount = 4, context = SpeakerNotes("""
    hash-tag channel is a public channel.
     
    Yes everything is encrypted, but the key is derived from channel name in this case.
""".trimIndent())) { stepIndex ->
    App3Slide(stepIndex)
}

@Composable
fun App3Slide(stepIndex: Int) {
    Box(Modifier.fillMaxSize().padding(vertical = 24.dp)) {
        Row(Modifier.fillMaxSize()) {
            Column {
                Text("Join #test channel")
                Spacer(Modifier.height(24.dp))
                Column {
                    AnimatedVisibility(stepIndex >= 0) {
                        Text("Select 'Add channel'")
                        Spacer(Modifier.height(32.dp))
                    }
                    AnimatedVisibility(stepIndex >= 1) {
                        Text("Select '# channel'")
                        Spacer(Modifier.height(32.dp))
                    }
                    AnimatedVisibility(stepIndex >= 2) {
                        Text("Type in 'test'")
                        Spacer(Modifier.height(32.dp))
                    }
                    AnimatedVisibility(stepIndex >= 3) {
                        Text("Send a message")
                        Spacer(Modifier.height(32.dp))
                    }
                }
            }

            Spacer(Modifier.width(32.dp))

            Column(
                Modifier.fillMaxHeight(),
                verticalArrangement = Arrangement.Center
            ) {
                val currentImageRes = when (stepIndex) {
                    0 -> Res.drawable.meshcore_app_menu
                    1 -> Res.drawable.meshcore_app_add_channel
                    2 -> Res.drawable.meshcore_app_add_channel_test
                    3 -> Res.drawable.meshcore_app_channel_test
                    else -> Res.drawable.meshcore_logo
                }
                val subtitle = when (stepIndex) {
                    0 -> "Press ... icon to open menu"
                    1 -> "Public channels use '#'"
                    2 -> "Fill in the channel name"
                    3 -> "Send your first message"
                    else -> ""
                }
                Image(
                    painterResource(currentImageRes),
                    contentDescription = "MeshCore app",
                    modifier = Modifier.weight(1f)
                )
                Spacer(Modifier.height(8.dp))
                Text(subtitle, style = MaterialTheme.typography.bodySmall)
                Spacer(Modifier.height(8.dp))
            }
        }
    }
}

@Composable
@Preview
fun PreviewApp3Slide() {
    App3Slide(0)
}
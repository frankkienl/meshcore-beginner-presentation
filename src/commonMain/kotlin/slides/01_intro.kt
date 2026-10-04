package slides

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import meshcore_beginner_presentation.generated.resources.Res
import meshcore_beginner_presentation.generated.resources.cup
import meshcore_beginner_presentation.generated.resources.meshcore_logo
import meshcore_beginner_presentation.generated.resources.wismesh_tag
import net.kodein.cup.Slide
import net.kodein.cup.speaker.SpeakerNotes
import net.kodein.cup.ui.styled
import org.jetbrains.compose.resources.painterResource
import org.kodein.emoji.Emoji
import org.kodein.emoji.compose.m3.TextWithPlatformEmoji
import org.kodein.emoji.smileys_emotion.face_smiling.Wink


val s01_intro by Slide(
    context = SpeakerNotes(
        """
            **Intro**
            
            First slide no longer says name of location.
            We've done this presentation at multiple locations now, 
            don't want to update the first slide every time.
        """.trimIndent()
    )
) {
    IntroSlide()
}

@Composable
fun IntroSlide() {
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "MeshCore workshop",
            style = MaterialTheme.typography.headlineLarge
        )
        HorizontalDivider(
            Modifier
                .padding(10.dp)
        )
        Text(text = "Flashing the WisMesh Tag and sending first message")

        Spacer(Modifier.height(25.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painterResource(Res.drawable.meshcore_logo),
                contentDescription = "Meshcore",
                modifier = Modifier.width(200.dp)
            )

            Spacer(Modifier.weight(0.1f))

            Box(
                Modifier
                    .background(color = MaterialTheme.colorScheme.primary, shape = MaterialTheme.shapes.small)
                    .padding(6.dp)
            ) {
                Image(
                    painterResource(Res.drawable.wismesh_tag),
                    contentDescription = "WisMesh Tag",
                    modifier = Modifier.width(75.dp)
                )
            }

        }
    }
}

@Composable
fun IntroSlide_OLD() {
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painterResource(Res.drawable.cup),
            contentDescription = "Compose ur Pres",
            modifier = Modifier
                .size(96.dp)
                .clip(CircleShape)
        )

        Text(
            text = "Hello, friend!",
            style = MaterialTheme.typography.headlineLarge
        )
        TextWithPlatformEmoji(styled { "Welcome to ${+b}Compose ur Pres${-b}! ${Emoji.Wink}" })
    }
}

@Composable
@Preview
fun PreviewIntroSlide() {
    IntroSlide()
}
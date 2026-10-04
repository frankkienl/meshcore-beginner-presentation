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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import meshcore_beginner_presentation.generated.resources.Res
import meshcore_beginner_presentation.generated.resources.mesh
import meshcore_beginner_presentation.generated.resources.meshcore_logo
import net.kodein.cup.Slide
import net.kodein.cup.speaker.SpeakerNotes
import org.jetbrains.compose.resources.painterResource

val s06_mesh by Slide(context = SpeakerNotes(
    """
        This is like a summary of previous slides. 
        A great point for people to ask questions before we move on.
    """.trimIndent()
)) {
    MeshSlide()
}

@Composable
fun MeshSlide() {
    Box(modifier = Modifier.fillMaxWidth()) {
        Column {
            Text(
                "So that's MeshCore",
                style = MaterialTheme.typography.headlineMedium
            )
            Text("Hopefully, the example helped answer these questions")
            Text("What: Communication over distance")
            Text("Why: Hobby, back-up plan (no power), Freedom")
            Text("When: Now; Since Jan 2024, but more useful recently")
            Text("Who: Anyone who wants to communicate (incl. beginners)")
            Text("Where: EU, and other places")
            Text("How: Radio communication via Mesh network")

            Spacer(Modifier.height(24.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painterResource(Res.drawable.meshcore_logo),
                    contentDescription = "MeshCore logo",
                    modifier = Modifier.height(32.dp)
                )
                Spacer(Modifier.weight(1f))
                Image(
                    painterResource(Res.drawable.mesh),
                    contentDescription = "A mesh fence",
                    modifier = Modifier.height(64.dp)
                )
            }
            Spacer(modifier = Modifier.height(32.dp))
        }
    }
}

@Composable
@Preview
fun PreviewMeshSlide() {
    MeshSlide()
}
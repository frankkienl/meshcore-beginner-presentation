package slides

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import net.kodein.cup.Slide

val s06_mesh by Slide {
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
            Spacer(modifier = Modifier.height(32.dp))
        }
    }
}

@Composable
@Preview
fun PreviewMeshSlide() {
    MeshSlide()
}
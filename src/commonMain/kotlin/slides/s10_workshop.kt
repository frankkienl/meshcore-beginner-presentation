package slides

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import meshcore_beginner_presentation.generated.resources.Res
import meshcore_beginner_presentation.generated.resources.wismesh_tag
import net.kodein.cup.Slide
import org.jetbrains.compose.resources.painterResource

val s10_workshop by Slide {
    WorkshopSlide()
}

@Composable
fun WorkshopSlide() {
    Box(
        Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painterResource(Res.drawable.wismesh_tag),
            contentDescription = "Wismesh Tag",
            modifier = Modifier.padding(16.dp).fillMaxSize()
        )
        Text(
            "Workshop",
            style = MaterialTheme.typography.headlineLarge
        )
    }
}


@Composable
@Preview
fun PreviewWorkshopSlide() {
    WorkshopSlide()
}
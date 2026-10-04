package slides

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import meshcore_beginner_presentation.generated.resources.Res
import meshcore_beginner_presentation.generated.resources.done
import meshcore_beginner_presentation.generated.resources.wismesh_tag_photo
import net.kodein.cup.Slide
import org.jetbrains.compose.resources.painterResource

val s11a_not_bad by Slide {
    NotBadSlide()
}

@Composable
fun NotBadSlide() {
    Box(Modifier.fillMaxSize()) {
        Row() {
            Image(
                painterResource(Res.drawable.wismesh_tag_photo),
                contentDescription = "Photo of WishMesh Tag"
            )
            Spacer(Modifier.width(16.dp))
            Column {
                Spacer(Modifier.height(16.dp))
                Text("That's it!")
                Text("It's very important you can do this")
                Text("Updates happen often")
                Spacer(Modifier.height(8.dp))
                Text("Teach your loved ones")

                Spacer(Modifier.height(16.dp))
                Image(
                    painterResource(Res.drawable.done),
                    contentDescription = "done"
                )
            }
        }
    }
}

@Preview
@Composable
fun PreviewNotBadSlide() {
    NotBadSlide()
}
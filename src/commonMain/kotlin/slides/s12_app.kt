package slides

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import meshcore_beginner_presentation.generated.resources.Res
import meshcore_beginner_presentation.generated.resources.pic_app
import meshcore_beginner_presentation.generated.resources.pic_bt_pair
import meshcore_beginner_presentation.generated.resources.pic_connect_bt
import net.kodein.cup.Slide
import org.jetbrains.compose.resources.painterResource

val s12_app by Slide {
    AppSlide()
}

@Composable
fun AppSlide() {
    Box(Modifier.fillMaxSize()) {
        Row() {
            Column {
                Spacer(Modifier.height(24.dp))
                Text("Setting up with App", style = MaterialTheme.typography.bodyMediumEmphasized)
                Spacer(Modifier.height(24.dp))
                Text("Open the MeshCore app", style = MaterialTheme.typography.bodySmall)
                Text("Click 'Connect'", style = MaterialTheme.typography.bodySmall)
                Text("Make sure Bluetooth is on", style = MaterialTheme.typography.bodySmall)
                Spacer(Modifier.height(16.dp))
                Text("Device should have a name,", style = MaterialTheme.typography.bodySmall)
                Text("related to Mac Address", style = MaterialTheme.typography.bodySmall)
                Spacer(Modifier.height(16.dp))
                Text("Default pin: 123456", style = MaterialTheme.typography.bodySmall)
            }
            Spacer(Modifier.width(4.dp))
            Image(
                painterResource(Res.drawable.pic_connect_bt),
                contentDescription = "MeshCore app",
                modifier = Modifier.fillMaxHeight()
            )
            Image(
                painterResource(Res.drawable.pic_bt_pair),
                contentDescription = "MeshCore app",
                modifier = Modifier.fillMaxHeight()
            )
        }
    }
}

@Composable
@Preview
fun PreviewAppSlide() {
    AppSlide()
}
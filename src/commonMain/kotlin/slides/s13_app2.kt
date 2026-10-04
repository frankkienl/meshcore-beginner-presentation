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
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import meshcore_beginner_presentation.generated.resources.Res
import meshcore_beginner_presentation.generated.resources.app_settings
import net.kodein.cup.Slide
import org.jetbrains.compose.resources.painterResource

val s13_app2 by Slide {
    App2Slide()
}

@Composable
fun App2Slide() {
    Box(Modifier.fillMaxSize()) {
        Row {
            Column {
                Spacer(Modifier.height(24.dp))
                Text("Setting up with App", style = MaterialTheme.typography.bodyMediumEmphasized)
                Spacer(Modifier.height(24.dp))
                Text("Change name of device", style = MaterialTheme.typography.bodySmall)
                Spacer(Modifier.height(16.dp))
                Text("Set preset to:", style = MaterialTheme.typography.bodySmall)
                Spacer(Modifier.height(4.dp))
                Text("Netherlands", style = MaterialTheme.typography.bodyMediumEmphasized)
                Spacer(Modifier.height(8.dp))
                Text("(used to be EU/UK)", style = MaterialTheme.typography.bodySmall)
                Spacer(Modifier.height(16.dp))
                Text("Use checkmark to apply", style = MaterialTheme.typography.bodySmall)
            }
            Spacer(Modifier.width(4.dp))
            Spacer(Modifier.weight(1f))
            Image(
                painterResource(Res.drawable.app_settings),
                contentDescription = "App settings",
                Modifier.fillMaxHeight()
            )
        }
    }
}


@Preview
@Composable
fun PreviewApp2Slide() {
    App2Slide()
}
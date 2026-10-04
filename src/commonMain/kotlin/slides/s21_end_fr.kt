package slides

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import net.kodein.cup.Slide
import net.kodein.cup.speaker.SpeakerNotes

val s21_end_fr by Slide(
    stepCount = 2, context = SpeakerNotes(
        """REAL END THIS TIME"""
    )
) { stepIndex ->
    EndFrSlide(stepIndex)
}

@Composable
fun EndFrSlide(stepIndex: Int) {
    Column {
        Text("The End", style = MaterialTheme.typography.headlineLargeEmphasized)

        AnimatedVisibility(stepIndex >= 1) {
            Column {
                Spacer(Modifier.height(16.dp))
                Text("For real this time!")

                Text("Go do something else now", style = MaterialTheme.typography.bodySmall)
            }
        }
    }
}

@Composable
@Preview
fun PreviewEndFrSlide() {
    EndFrSlide(0)
}

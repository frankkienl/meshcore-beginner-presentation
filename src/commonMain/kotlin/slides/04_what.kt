package slides

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import meshcore_beginner_presentation.generated.resources.Res
import meshcore_beginner_presentation.generated.resources.what
import net.kodein.cup.Slide
import org.jetbrains.compose.resources.painterResource

val s04_what by Slide {
    WhatSlide()
}

@Composable
fun WhatSlide() {
    Box(modifier = Modifier.fillMaxWidth()) {
        Column {
            Spacer(modifier = Modifier.height(32.dp))
            Text(
                "Who, What, Where, Why, When, How",
                style = MaterialTheme.typography.headlineMedium
            )
            Text("What: A means to communicate over distance")
            Text("Who: Anyone who wants to communicate (incl. beginners)")
            Text("Where: EU, and other places")
            Text("Why: Hobby, back-up plan, Freedom")
            Text("When: Since Jan 2024, but more useful recently")
            Text("How: Radio communication via Mesh network")
            Spacer(modifier = Modifier.height(32.dp))
            Text(
                "Not very useful answers, let's go into details using an example",
                fontStyle = FontStyle.Italic
            )
        }

        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.End,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painterResource(Res.drawable.what),
                modifier = Modifier.width(110.dp),
                contentDescription = "What"
            )
        }
    }
}

@Composable
@Preview
fun PreviewWhatSlide() {
    WhatSlide()
}
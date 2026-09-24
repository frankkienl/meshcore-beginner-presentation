package slides

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
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
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import meshcore_beginner_presentation.generated.resources.Res
import meshcore_beginner_presentation.generated.resources.alice
import meshcore_beginner_presentation.generated.resources.bob
import meshcore_beginner_presentation.generated.resources.cat_speaking
import meshcore_beginner_presentation.generated.resources.elmo_thunder
import meshcore_beginner_presentation.generated.resources.green_check
import meshcore_beginner_presentation.generated.resources.lilygo_tdeck
import meshcore_beginner_presentation.generated.resources.red_cross
import meshcore_beginner_presentation.generated.resources.smartphone_in_hand
import net.kodein.cup.Slide
import org.jetbrains.compose.resources.painterResource

val s05_example_situation by Slide(
    stepCount = 7
) { stepIndex ->
    ExampleSituationSlide(stepIndex)
}

@Composable
fun ExampleSituationSlide(step: Int) {
    Box(modifier = Modifier.fillMaxSize()) {
        Column {
            Spacer(Modifier.height(8.dp))
            Text("Let's check an example situation (${step + 1})")

            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier.fillMaxHeight(),
                    verticalArrangement = Arrangement.Center
                ) {
                    Image(
                        painterResource(Res.drawable.alice),
                        modifier = Modifier.width(64.dp),
                        contentDescription = "Alice",
                    )
                }

                Column(
                    modifier = Modifier.weight(0.1f)
                ) {
                    AnimatedVisibility((step == 0)) { Sit1() }
                    AnimatedVisibility((step == 1)) { Sit2() }
                    AnimatedVisibility((step == 2)) { Sit3() }
                    AnimatedVisibility((step == 3)) { Sit4() }
                    AnimatedVisibility((step == 4)) { Sit1() }
                    AnimatedVisibility((step == 5)) { Sit1() }
                    AnimatedVisibility((step == 6)) { Sit1() }
                }

                Column(
                    modifier = Modifier.fillMaxHeight(),
                    verticalArrangement = Arrangement.Center
                ) {
                    Image(
                        painterResource(Res.drawable.bob),
                        modifier = Modifier.width(64.dp),
                        contentDescription = "Bob",
                    )
                }
            }
        }
    }
}

@Composable
fun Sit1() {
    Column {
        Spacer(Modifier.height(32.dp))
        Text("Let's assume, Alica and Bob want communicate")
        Spacer(Modifier.height(16.dp))
        Text("If they are close enough, they can just talk. No technology needed.")
        Spacer(Modifier.height(16.dp))
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row {
                Image(
                    painterResource(Res.drawable.cat_speaking),
                    contentDescription = "Cat speaking",
                    modifier = Modifier.height(64.dp)
                )
                Spacer(Modifier.width(16.dp))
                Image(
                    painterResource(Res.drawable.green_check),
                    contentDescription = "Green check",
                    modifier = Modifier.height(64.dp)
                )
            }
        }
    }
}


@Composable
fun Sit2() {
    Column {
        Spacer(Modifier.height(32.dp))
        Text("Add some distance... Shouting is not enough.")
        Spacer(Modifier.height(16.dp))
        Text("Give them smartphones. Problem solved.")
        Spacer(Modifier.height(16.dp))
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row {
                Image(
                    painterResource(Res.drawable.smartphone_in_hand),
                    contentDescription = "Smartphone in hand",
                    modifier = Modifier.height(64.dp)
                )
                Spacer(Modifier.width(16.dp))
                Image(
                    painterResource(Res.drawable.smartphone_in_hand),
                    contentDescription = "Smartphone in hand",
                    modifier = Modifier.height(64.dp)
                )
                Spacer(Modifier.width(16.dp))
                Image(
                    painterResource(Res.drawable.green_check),
                    contentDescription = "Green check",
                    modifier = Modifier.height(64.dp)
                )
            }
        }
    }
}

@Composable
fun Sit3() {
    Column {
        Spacer(Modifier.height(32.dp))
        Text("Same distance as before")
        Spacer(Modifier.height(16.dp))
        Text("But the smartphones don't work today, due to some disaster.")
        Text("(Like a power outage that broke the mobile network)")
        Spacer(Modifier.height(16.dp))
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painterResource(Res.drawable.smartphone_in_hand),
                    contentDescription = "Smartphone in hand",
                    modifier = Modifier.height(64.dp)
                )
                Spacer(Modifier.width(8.dp))
                Image(
                    painterResource(Res.drawable.elmo_thunder),
                    contentDescription = "Elmo thunder",
                    modifier = Modifier.height(32.dp)
                )
                Spacer(Modifier.width(8.dp))
                Image(
                    painterResource(Res.drawable.smartphone_in_hand),
                    contentDescription = "Smartphone in hand",
                    modifier = Modifier.height(64.dp)
                )
                Spacer(Modifier.width(8.dp))
                Image(
                    painterResource(Res.drawable.red_cross),
                    contentDescription = "Red Cross",
                    modifier = Modifier.height(48.dp)
                )
            }
        }
    }
}

@Composable
fun Sit4() {
    Column {
        Spacer(Modifier.height(32.dp))
        Text("No smartphones, let's try MeshCore")
        Text("If the distance is < 10 km ~ish; Problem solved")
        Spacer(Modifier.height(16.dp))
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    "Battery powered, no power no problem.",
                    fontSize = 10.sp,
                    lineHeight = 10.sp,
                    modifier = Modifier.widthIn(min = 10.dp, max = 50.dp)
                )
                Image(
                    painterResource(Res.drawable.lilygo_tdeck),
                    contentDescription = "Lilygo T-Deck",
                    modifier = Modifier.height(64.dp)
                )
                Spacer(Modifier.width(8.dp))
                Text(
                    "Peer to peer",
                    fontSize = 10.sp,
                    modifier = Modifier.widthIn(min = 10.dp, max = 60.dp)
                )
                Spacer(Modifier.width(8.dp))
                Image(
                    painterResource(Res.drawable.lilygo_tdeck),
                    contentDescription = "Lilygo T-Deck",
                    modifier = Modifier.height(32.dp)
                )
                Spacer(Modifier.width(8.dp))
                Image(
                    painterResource(Res.drawable.green_check),
                    contentDescription = "Green check",
                    modifier = Modifier.height(48.dp)
                )
            }
        }
    }
}


@Composable
@Preview
fun PreviewExampleSituationSlide() {
    ExampleSituationSlide(1)
}
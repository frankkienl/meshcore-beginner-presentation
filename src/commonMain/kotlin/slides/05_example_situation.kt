package slides

import androidx.compose.animation.AnimatedVisibility
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
import meshcore_beginner_presentation.generated.resources.repeater
import meshcore_beginner_presentation.generated.resources.smartphone_in_hand
import meshcore_beginner_presentation.generated.resources.wismesh_tag
import net.kodein.cup.Slide
import net.kodein.cup.speaker.SpeakerNotes
import org.jetbrains.compose.resources.painterResource
import utils.GifImage

val s05_example_situation by Slide(
    context = SpeakerNotes(
        listOf(
            0..0 to """
                There are 7 steps in this slide! (index+1; 1 - 7)
          
                Alice and Bob are default names for talking about communication protocols; As in Person A and Person B.  
                These names were always used during lectures on communication and cryptography  
                  
                So sad the GIF's don't work (yet?)
            """.trimIndent(),
            1..1 to """
                Smartphones, they can call or text  
                
                Problem solved, when making a LOT of assumptions!
                Most importantly: We assume the 3G/4G/5G networks are working
            """.trimIndent(),
            2..2 to """
                Now disaster strikes; We all received that booklet from the government!  
                We should prepare a emergency kit; With an FM radio and a flashlight; Oh and food for 3 days.  

                Power outage, cell network may survive a few hours. 
                But (probably) not days. May not be related to lightning-storms.
            """.trimIndent(),
            3..3 to """
                LilyGO T-Deck Plus. Show device!  
                
                Ditch the smartphone, and the proprietary networks. Don’t be a slave to corporations and/or the government.  
                We’ll make our own communication, with Blackjack and … Meshcore!!  
            """.trimIndent(),
            4..4 to """
                With bigger distances, the signal doesn’t reach. No more communication like “walkie-talkies”.
                We need a signal booster. We can’t just increase the wattage of our transmitters though! These are limited by EU regulations.
                Amateurs are only allowed to transmit a certain wattage, to make sure other signals aren’t disrupted.

                What we can do, is use a repeater. It will hear (receive) the message from Alice, and re-transmit it so Bob can receive it.    
            """.trimIndent(),
            5..5 to """
                With a bigger distance we can just increase the number of repeats.
                MeshCore has a default hop limit of 64; Unlike Meshtastic
            """.trimIndent(),
            6..6 to """
                In the previous slides, I’ve shown the LilyGO T-Deck devices; 
                These are stand-alone devices. As in, no Smartphone needed. 
                Just the LilyGO T-Deck is enough to communicate.

                But in practice, we’re going to flash the SenseCAP tracker devices.
                These are smaller, and therefore easier to always have on you.
                But they are no ‘stand-alone’, in this context that means you also need a smartphone to use them.

                The SenseCAP tracker devices (companion devices) don’t have a keyboard, (or screen)
                that’s the reason you need to use a smartphone as keyboard. You connect using BLE.
                Note: The Heltec V3 (red device in picture) does have a screen, but still no keyboard, and is also considered not ‘stand-alone’.

                You could kinda see the companion device, as little more than a translation layer between BLE and MeshCore (LoRa).

                Afaik, there are no modern smartphones with LoRa build-in at this moment.
                ( And no, the LilyGO device don’t fit my definition of a modern smartphone ! )

                The reason I picked the SenseCAP trackers for this workshop:
                Cheap~ish 45 euro (cheaper than the LilyGO T-Deck+)
                No soldering required, ready to flash out-of-the-box
                Small form-factor
                Recommended device by MeshCore (and community members like Anne-Jan / Ranzbak)
                Beginner friendly, the MeshCore app is more convenient compared to the UX on the T-Deck
            """.trimIndent()
        )
    ),
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
                    GifImage(
                        painterResource(Res.drawable.alice),
                        path = "drawable/alice.gif",
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
                    AnimatedVisibility((step == 4)) { Sit5() }
                    AnimatedVisibility((step == 5)) { Sit6() }
                    AnimatedVisibility((step == 6)) { Sit7() }
                }

                Column(
                    modifier = Modifier.fillMaxHeight(),
                    verticalArrangement = Arrangement.Center
                ) {
                    GifImage(
                        painterResource(Res.drawable.bob),
                        path = "drawable/bob.gif",
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
                GifImage(
                    painterResource(Res.drawable.cat_speaking),
                    path = "drawable/cat_speaking.gif",
                    contentDescription = "Cat speaking",
                    modifier = Modifier.height(64.dp)
                )
                Spacer(Modifier.width(16.dp))
                GifImage(
                    painterResource(Res.drawable.green_check),
                    path = "drawable/green_check.gif",
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
                GifImage(
                    painterResource(Res.drawable.elmo_thunder),
                    path = "drawable/elmo_thunder.gif",
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
        Text("Battery powered, no power no problem.")
        Spacer(Modifier.height(16.dp))
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painterResource(Res.drawable.lilygo_tdeck),
                    contentDescription = "Lilygo T-Deck",
                    modifier = Modifier.height(64.dp)
                )
                Spacer(Modifier.width(8.dp))
                Text(
                    "Peer to peer",
                    fontSize = 12.sp,
                    modifier = Modifier.widthIn(min = 10.dp, max = 70.dp)
                )
                Spacer(Modifier.width(8.dp))
                Image(
                    painterResource(Res.drawable.lilygo_tdeck),
                    contentDescription = "Lilygo T-Deck",
                    modifier = Modifier.height(64.dp)
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
fun Sit5() {
    Column {
        Spacer(Modifier.height(32.dp))
        Text("No smartphones, let's try MeshCore")
        Text("If the distance is < 10 km ~ish; Problem solved")
        Text("Battery powered, no power no problem.")
        Spacer(Modifier.height(16.dp))
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painterResource(Res.drawable.lilygo_tdeck),
                    contentDescription = "Lilygo T-Deck",
                    modifier = Modifier.height(64.dp)
                )
                Spacer(Modifier.width(8.dp))
                Image(
                    painterResource(Res.drawable.repeater),
                    contentDescription = "repeater",
                    modifier = Modifier.height(64.dp)
                )
                Spacer(Modifier.width(8.dp))
                Image(
                    painterResource(Res.drawable.lilygo_tdeck),
                    contentDescription = "Lilygo T-Deck",
                    modifier = Modifier.height(64.dp)
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
fun Sit6() {
    Column {
        Spacer(Modifier.height(32.dp))
        Text("Even bigger distance")
        Text("Just add repeaters")
        Text("Hops < 64")
        Spacer(Modifier.height(16.dp))
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painterResource(Res.drawable.lilygo_tdeck),
                    contentDescription = "Lilygo T-Deck",
                    modifier = Modifier.height(64.dp)
                )
                Spacer(Modifier.width(8.dp))
                Image(
                    painterResource(Res.drawable.repeater),
                    contentDescription = "repeater",
                    modifier = Modifier.height(64.dp)
                )
                Spacer(Modifier.width(8.dp))
                Image(
                    painterResource(Res.drawable.repeater),
                    contentDescription = "repeater",
                    modifier = Modifier.height(64.dp)
                )
                Spacer(Modifier.width(8.dp))
                Image(
                    painterResource(Res.drawable.repeater),
                    contentDescription = "repeater",
                    modifier = Modifier.height(64.dp)
                )
                Spacer(Modifier.width(8.dp))
                Image(
                    painterResource(Res.drawable.lilygo_tdeck),
                    contentDescription = "Lilygo T-Deck",
                    modifier = Modifier.height(64.dp)
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
fun Sit7() {
    Column {
        Spacer(Modifier.height(32.dp))
        Text("No smartphones, let's try MeshCore")
        Text("If the distance is < 10 km ~ish; Problem solved")
        Text("Battery powered, no power no problem.")
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
                    modifier = Modifier.height(48.dp)
                )
                Image(
                    painterResource(Res.drawable.wismesh_tag),
                    contentDescription = "WisMesh Tag",
                    modifier = Modifier.height(48.dp)
                )
                Spacer(Modifier.width(8.dp))
                Image(
                    painterResource(Res.drawable.repeater),
                    contentDescription = "repeater",
                    modifier = Modifier.height(48.dp)
                )
                Spacer(Modifier.width(8.dp))
                Image(
                    painterResource(Res.drawable.repeater),
                    contentDescription = "repeater",
                    modifier = Modifier.height(48.dp)
                )
                Spacer(Modifier.width(8.dp))
                Image(
                    painterResource(Res.drawable.repeater),
                    contentDescription = "repeater",
                    modifier = Modifier.height(48.dp)
                )
                Spacer(Modifier.width(8.dp))
                Image(
                    painterResource(Res.drawable.wismesh_tag),
                    contentDescription = "WisMesh Tag",
                    modifier = Modifier.height(48.dp)
                )
                Image(
                    painterResource(Res.drawable.smartphone_in_hand),
                    contentDescription = "Smartphone in hand",
                    modifier = Modifier.height(48.dp)
                )
                Spacer(Modifier.width(8.dp))
                Image(
                    painterResource(Res.drawable.green_check),
                    contentDescription = "Green check",
                    modifier = Modifier.height(32.dp)
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
package org.es.tomas.pedra_paper_tisores.ui.Screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import org.es.tomas.pedra_paper_tisores.Model.Enums.Plays
import org.es.tomas.pedra_paper_tisores.Model.DataClasses.Player
import org.es.tomas.pedra_paper_tisores.ui.Common.Botó
import org.es.tomas.pedra_paper_tisores.ui.Navigation.HomePageDestiny

@Composable
fun EndOfRoundScreen(
    rival: Player,
    yourPlay: Plays,
    rivalPlay: Plays,
    navController: NavController = rememberNavController(),
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.primary)
            .padding(
                top = 25.dp,
                start = 10.dp,
                end = 10.dp,
                bottom = 25.dp
            )
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.secondary)
                .align(Alignment.CenterHorizontally)
        ) {
            Text(
                text = "--- ${rival.name} VS YOU ---",
                style = MaterialTheme.typography.displayMedium,
                color = MaterialTheme.colorScheme.onSecondary
            )
        }
        HorizontalDivider(Modifier
            .padding(
                top = 15.dp,
                bottom = 75.dp
            )
            .fillMaxWidth()
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.secondary)
                .align(Alignment.CenterHorizontally)
        ) {
            Text(
                text = "YOUR PLAY: $yourPlay",
                style = MaterialTheme.typography.displaySmall,
                color = MaterialTheme.colorScheme.onSecondary,
                textAlign = TextAlign.Center
            )
        }
        Spacer(Modifier.padding(25.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.secondary)
                .align(Alignment.CenterHorizontally)
        ) {
            Text(
                text = "RIVAL'S PLAY: $rivalPlay",
                style = MaterialTheme.typography.displaySmall,
                color = MaterialTheme.colorScheme.onSecondary,
                textAlign = TextAlign.Center
            )
        }
        HorizontalDivider(Modifier
            .padding(
                top = 15.dp,
                bottom = 200.dp
            )
            .fillMaxWidth()
        )
        Botó(
            text = "PLAY AGAIN",
            click = {
                navController.navigate(HomePageDestiny)
            }
        )
    }
}

@Preview
@Composable
fun preview(){
    val rival = Player("Joan")
    EndOfRoundScreen(rival, Plays.SCISSORS, Plays.SPOCK)
}
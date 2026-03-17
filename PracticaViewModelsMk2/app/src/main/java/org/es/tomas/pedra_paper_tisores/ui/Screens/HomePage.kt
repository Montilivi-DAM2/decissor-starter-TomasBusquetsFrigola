package org.es.tomas.pedra_paper_tisores.ui.Screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import org.es.tomas.pedra_paper_tisores.Model.DataClasses.Data
import org.es.tomas.pedra_paper_tisores.Model.DataClasses.Player
import org.es.tomas.pedra_paper_tisores.ui.Common.Botó
import org.es.tomas.pedra_paper_tisores.ui.Navigation.PreferencesScreenDestiny
import org.es.tomas.pedra_paper_tisores.ui.Navigation.RockPaperScissorsDestiny

@Preview
@Composable
fun HomePage(
//    onClick: () -> Unit = {},
    navController: NavHostController = rememberNavController(),
){
    val data = Data()
    var nDefeated = 0
    var nLost = 0
    var player: Player

    data.createPlayer()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.primary)
            .padding(48.dp)
    ) {
        Text(
            text = "WELCOME TO ROCK, PAPER, SCISSORS, SPOCK, LIZARD",
            style = MaterialTheme.typography.headlineLarge,
            color = MaterialTheme.colorScheme.onPrimary,
            textAlign = TextAlign.Center
        )
        HorizontalDivider(Modifier.padding(15.dp))
        player = data.players[nDefeated]
        Text(
            text = "A NEW CHALLENGE APPROACHES!",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSecondary,
            modifier = Modifier.padding(
                start = 40.dp
            )
        )
        Text(
            text = player.toString(),
            style = MaterialTheme.typography.displaySmall,
            color = MaterialTheme.colorScheme.onTertiary,
            textAlign = TextAlign.Center
        )
        Spacer(Modifier.padding(80.dp))
        Botó(
            text = "PLAY",
            click = {
                navController.navigate(PreferencesScreenDestiny(player))
            }
        )
//        Spacer(Modifier.padding(20.dp))
        Text(
            text = "ROUNDS WON: $nDefeated     ROUNDS LOST: $nLost",
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onTertiary,
            modifier = Modifier.padding(
                top = 20.dp,
                start = 10.dp
            )
        )
    }
}
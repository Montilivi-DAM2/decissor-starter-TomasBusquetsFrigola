package org.es.tomas.pedra_paper_tisores.ui.Screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextAlign.Companion.Center
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import org.es.tomas.pedra_paper_tisores.Model.Data
import org.es.tomas.pedra_paper_tisores.Model.Enums.Plays
import org.es.tomas.pedra_paper_tisores.Model.Player

@Composable
fun GameScreen(
    navController: NavController = rememberNavController(),
    rival: Player
) {
    val rivalPlay: Plays
    rival.hasPlayedRound()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.primary)
            .padding(
                start = 15.dp,
                top = 60.dp,
                end = 15.dp,
                bottom = 0.dp
            )
    ) {
        Box(
            modifier = Modifier
                .background(color = MaterialTheme.colorScheme.secondary)
                .fillMaxWidth()
                .size(150.dp)
                .align(Alignment.CenterHorizontally)
        ) {
            Text(
                text = rival.name,
                style = MaterialTheme.typography.displaySmall,
//                textAlign = TextAlign.Center
            )

        }
    }
}

@Preview
@Composable
fun previewSreen() {
    val player: Player
    val gameData = Data()
    gameData.createPlayer()
    player = gameData.players[0]
    GameScreen(
        rival = player
    )
}
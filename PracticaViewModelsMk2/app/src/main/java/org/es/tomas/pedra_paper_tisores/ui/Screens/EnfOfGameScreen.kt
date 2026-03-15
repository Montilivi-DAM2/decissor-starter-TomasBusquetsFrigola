package org.es.tomas.pedra_paper_tisores.ui.Screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.es.tomas.pedra_paper_tisores.Model.DataClasses.Player

@Composable
fun EndOfGameScreen(
    rival: Player
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.primary)
            .padding(
                top = 25.dp,
                start = 10.dp,
                end = 10.dp,
                bottom = 25.dp
            ),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        if (rival.wonRounds >= 3) {
            Text(
                text = "YOU LOST",
                color = MaterialTheme.colorScheme.onPrimary,
                style = MaterialTheme.typography.headlineLarge
            )
        } else if (rival.lostRounds >= 3) {
            Text(
                text = "YOU WON",
                color = MaterialTheme.colorScheme.onPrimary,
                style = MaterialTheme.typography.headlineLarge
            )
        }
    }
}

@Preview
@Composable
fun Preview() {
    val player = Player(
        "Joan",
        wonRounds = 2,
        lostRounds = 3
    )
    EndOfGameScreen(player)
}
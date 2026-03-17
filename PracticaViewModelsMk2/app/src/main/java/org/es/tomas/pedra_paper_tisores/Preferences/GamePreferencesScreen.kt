package org.es.tomas.pedra_paper_tisores.Preferences

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.launch
import org.es.tomas.pedra_paper_tisores.Model.DataClasses.Player
import org.es.tomas.pedra_paper_tisores.Model.DataStorage.MyPreferencesDataStore
import org.es.tomas.pedra_paper_tisores.ui.Common.GamemodeBox
import org.es.tomas.pedra_paper_tisores.ui.Common.PlayerNameBox
import org.es.tomas.pedra_paper_tisores.ui.Common.RoundsBox
import org.es.tomas.pedra_paper_tisores.ui.Navigation.RockPaperScissorsDestiny

//import org.es.tomas.pedra_paper_tisores.ui.Common.GamemodeBox

@Preview
@Composable
fun GamePreferencesScreen(
    navController: NavController = rememberNavController(),
    player: Player = Player("")
) {
    val preferences = MyPreferencesDataStore(context = LocalContext.current)
    val gamemode by preferences.getGamemode.collectAsState(0)
    val nRounds by preferences.getNRounds.collectAsState(0)
    val playerName by preferences.getPlayerName.collectAsState(0)
    val coroutineScope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.primary)
            .padding(
                start = 15.dp,
                top = 15.dp,
                end = 15.dp,
                bottom = 15.dp
            ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "GAME PREFERENCES",
            style = MaterialTheme.typography.headlineLarge,
            color = MaterialTheme.colorScheme.onPrimary,
        )
        HorizontalDivider(
            Modifier.padding(
                top = 5.dp,
                bottom = 10.dp
            )
        )
        GamemodeBox(
            onGamemodeValueChange = { value ->
                coroutineScope.launch {
                    preferences.setGamemode(value)
                }
            }
        )
        RoundsBox(
            nRounds = nRounds,
            onNumberRoundsChange = { nRounds ->
                coroutineScope.launch {
                    preferences.setMinNRounds(nRounds)
                }
            }
        )
        PlayerNameBox(
            playerName = playerName.toString(),
            onNameChange = { name ->
                coroutineScope.launch {
                    preferences.setPlayerName(name)
                }
            }
        )
        Button(
            onClick = {
                navController.navigate(RockPaperScissorsDestiny(player))
            },
            modifier = Modifier
                .fillMaxWidth(),
            enabled = true,
            colors = ButtonColors(
                containerColor = MaterialTheme.colorScheme.surface,
                contentColor = MaterialTheme.colorScheme.onSurface,
                disabledContainerColor = MaterialTheme.colorScheme.background,
                disabledContentColor = MaterialTheme.colorScheme.onBackground
            )
        ) {
            Text("PLAY")
        }
    }
}
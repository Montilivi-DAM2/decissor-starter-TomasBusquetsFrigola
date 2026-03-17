package org.es.tomas.pedra_paper_tisores.ui.Common

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import org.es.tomas.pedra_paper_tisores.Model.Enums.Plays
import org.es.tomas.pedra_paper_tisores.Model.DataClasses.Player
import org.es.tomas.pedra_paper_tisores.ui.Screens.compareSelectedOptions
import org.es.tomas.pedra_paper_tisores.ui.ViewModels.GameScreenViewModel

@Composable
fun Botó (
    modifier: Modifier = Modifier,
    text: String = "",
    click: () -> Unit
) {
    OutlinedButton(
        elevation = ButtonDefaults.buttonElevation(
            defaultElevation = 0.dp,
            pressedElevation = 8.dp,
            disabledElevation = 0.dp
        ),
        onClick = click,
        shape = RoundedCornerShape(28.dp),
        modifier = modifier,
        contentPadding = PaddingValues(15.dp),
        colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.secondary),
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.outline)
    ) {
        Row(modifier = Modifier
            .fillMaxWidth()
            .align(alignment = Alignment.CenterVertically) )
        {
            Text(
                text = text,
                color = MaterialTheme.colorScheme.onSecondary,
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.displaySmall,
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.CenterVertically)
            )
        }

    }
}

@Composable
fun PlaySelector(
    viewModel: GameScreenViewModel,
    rival: Player,
    navController: NavController,
    textOption: Plays,
    nRounds: Int
) {
    Botó(
        text = textOption.toString(),
        click = {
            viewModel.decide(500L)
            compareSelectedOptions(
                rivalPlay = viewModel.state.result,
                yourPlay = textOption,
                rival = rival,
                navController = navController,
                nRounds = nRounds
            )
        }
    )
}

@Composable
fun ColumnScope.GameResultDisplay(play: Plays) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.secondary)
            .align(Alignment.CenterHorizontally)
    ) {
        Text(
            text = "YOUR PLAY: $play",
            style = MaterialTheme.typography.displaySmall,
            color = MaterialTheme.colorScheme.onSecondary,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun GamemodeBox(
    onGamemodeValueChange: (gamemode: String) -> Unit
) {
    Card(
        modifier = Modifier
            .padding(16.dp),
        colors = CardDefaults.cardColors(
            contentColor = MaterialTheme.colorScheme.primary,
            containerColor = MaterialTheme.colorScheme.surface
        )
    ) {
        Column(
            Modifier.padding(16.dp)
        ) {
            Text(
                text = "GAME MODE",
                style = MaterialTheme.typography.headlineMedium
            )
            HorizontalDivider(
                Modifier.padding(
                    top = 5.dp,
                    bottom = 10.dp
                )
            )
            Text(
                text = "Choose the game mode:",
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(bottom = 4.dp)
            )
            Row(

            ) {
                Botó(
                    modifier = Modifier.weight(4f),
                    text = "Standard",
                    click = { onGamemodeValueChange("Standard") }
                )
                Spacer(Modifier.weight(1f))
                Botó(
                    modifier = Modifier.weight(4f),
                    text = "Sheldon",
                    click = { onGamemodeValueChange("Sheldon") }
                )
            }
        }
    }
}

@Composable
fun RoundsBox(
    nRounds: Int,
    onNumberRoundsChange: (Int) -> Unit
) {
    Card(
        modifier = Modifier
            .padding(16.dp),
        colors = CardDefaults.cardColors(
            contentColor = MaterialTheme.colorScheme.primary,
            containerColor = MaterialTheme.colorScheme.surface
        )
    ) {
        Column(
            Modifier
                .padding(16.dp)
        ) {
            Text(
                text = "NUMBER OF ROUNDS",
                style = MaterialTheme.typography.headlineMedium
            )
            HorizontalDivider(
                Modifier.padding(
                    top = 5.dp,
                    bottom = 10.dp
                )
            )
            Text(
                text = "Choose the number of rounds:",
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(4.dp)
            )
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Slider(
                    modifier = Modifier
                        .weight(8f),
                    value = nRounds.toFloat(),
                    onValueChange = {
                        onNumberRoundsChange(it.toInt())
                    },
                    valueRange = (1f..10f)
                )
                Text(
                    text = nRounds.toString(),
                    modifier = Modifier
                        .weight(1f)
                )
            }
        }
    }
}

@Composable
fun PlayerNameBox(
    playerName: String,
    onNameChange: (String) -> Unit
) {
    var newName: String = playerName
    Card(
        modifier = Modifier
            .padding(16.dp),
        colors = CardDefaults.cardColors(
            contentColor = MaterialTheme.colorScheme.primary,
            containerColor = MaterialTheme.colorScheme.surface
        )
    ) {
        Column(
            Modifier.padding(16.dp)
        ) {
            Text(
                text = "SET YOUR NAME:",
                style = MaterialTheme.typography.headlineMedium
            )
            HorizontalDivider(
                Modifier.padding(
                    top = 5.dp,
                    bottom = 10.dp
                )
            )
            OutlinedTextField(
                value = "",
                onValueChange = {
                    newName = it
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.CenterHorizontally),
                label = {Text("Your name", style = MaterialTheme.typography.headlineSmall)},
                singleLine = true,
            )
            Spacer(Modifier.padding(1.dp))
            Botó(
                text = "Submitt",
                click = {
                    onNameChange(newName)
                }
            )
        }
    }
}
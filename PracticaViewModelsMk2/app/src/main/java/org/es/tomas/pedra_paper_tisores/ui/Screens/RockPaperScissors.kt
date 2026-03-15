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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import org.es.tomas.pedra_paper_tisores.Model.Data
import org.es.tomas.pedra_paper_tisores.Model.Enums.Plays
import org.es.tomas.pedra_paper_tisores.Model.Player
import org.es.tomas.pedra_paper_tisores.ui.Common.PlaySelector
import org.es.tomas.pedra_paper_tisores.ui.Navigation.EndOfGameScreenDestiny
import org.es.tomas.pedra_paper_tisores.ui.Navigation.EndOfRoundScreenDestiny
//import org.es.tomas.pedra_paper_tisores.ui.Screens.RockPaperScissors
import org.es.tomas.pedra_paper_tisores.ui.ViewModels.GameScreenViewModel

//region: Screen
@Composable
fun RockPaperScissors(
    rival: Player,
    viewModel: GameScreenViewModel = viewModel(),
    navController: NavController = rememberNavController(),
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.primary)
            .padding(
                start = 15.dp,
                top = 60.dp,
                end = 15.dp,
                bottom = 60.dp
            ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = rival.name,
            style = MaterialTheme.typography.headlineSmall,
            textAlign = TextAlign.Center,
            color = MaterialTheme.colorScheme.onPrimary
        )
        HorizontalDivider(Modifier.padding(20.dp))
        PlaySelector(viewModel, rival, navController, Plays.ROCK)
        Spacer(Modifier.padding(5.dp))
        PlaySelector(viewModel, rival, navController, Plays.PAPER)
        Spacer(Modifier.padding(5.dp))
        PlaySelector(viewModel, rival, navController, Plays.SCISSORS)
        Spacer(Modifier.padding(5.dp))
        PlaySelector(viewModel, rival, navController, Plays.SPOCK)
        Spacer(Modifier.padding(5.dp))
        PlaySelector(viewModel, rival, navController, Plays.LIZARD)
    }
}



@Preview
@Composable
fun previewSreen() {
    val player: Player
    val gameData = Data()
    gameData.createPlayer()
    player = gameData.players[0]
    RockPaperScissors(rival = player)
}
//endregion

//region: Funcions internes de la pantalla
fun compareSelectedOptions(
    rivalPlay: Plays,
    yourPlay: Plays,
    rival: Player,
    navController: NavController
) {
    if (yourPlay == Plays.PAPER) {
        if (rivalPlay == Plays.SCISSORS || rivalPlay == Plays.LIZARD) {
            rival.hasWonRound()
            if (rival.wonRounds >= 3) {
                navController.navigate(EndOfGameScreenDestiny(rival))
            } else {
                navController.navigate(
                    route = EndOfRoundScreenDestiny(
                        rival = rival,
                        yourPlay = yourPlay,
                        rivalPlays = rivalPlay
                    )
                )
            }
        }
        else if (rivalPlay == Plays.ROCK || rivalPlay == Plays.SPOCK) {
            rival.hasLostRound()
            if (rival.lostRounds >= 3) {
                navController.navigate(EndOfGameScreenDestiny(rival))
            } else {
                navController.navigate(
                    route = EndOfRoundScreenDestiny(
                        rival = rival,
                        yourPlay = yourPlay,
                        rivalPlays = rivalPlay
                    )
                )
            }
        }
        else {
            navController.navigate(
                route = EndOfRoundScreenDestiny(
                    rival = rival,
                    yourPlay = yourPlay,
                    rivalPlays = rivalPlay
                )
            )
        }
    }
    else if (yourPlay == Plays.SCISSORS) {
        if (rivalPlay == Plays.ROCK || rivalPlay == Plays.SPOCK) {
            rival.hasWonRound()
            if (rival.wonRounds >= 3) {
                navController.navigate(EndOfGameScreenDestiny(rival))
            } else {
                navController.navigate(
                    route = EndOfRoundScreenDestiny(
                        rival = rival,
                        yourPlay = yourPlay,
                        rivalPlays = rivalPlay
                    )
                )
            }
        }
        else if (rivalPlay == Plays.PAPER || rivalPlay == Plays.LIZARD) {
            rival.hasLostRound()
            if (rival.lostRounds >= 3) {
                navController.navigate(EndOfGameScreenDestiny(rival))
            } else {
                navController.navigate(
                    route = EndOfRoundScreenDestiny(
                        rival = rival,
                        yourPlay = yourPlay,
                        rivalPlays = rivalPlay
                    )
                )
            }
        }
        else {
            navController.navigate(
                route = EndOfRoundScreenDestiny(
                    rival = rival,
                    yourPlay = yourPlay,
                    rivalPlays = rivalPlay
                )
            )
        }
    }
    else if (yourPlay == Plays.ROCK) {
        if (rivalPlay == Plays.SCISSORS || rivalPlay == Plays.LIZARD) {
            rival.hasWonRound()
            if (rival.wonRounds >= 3) {
                navController.navigate(EndOfGameScreenDestiny(rival))
            } else {
                navController.navigate(
                    route = EndOfRoundScreenDestiny(
                        rival = rival,
                        yourPlay = yourPlay,
                        rivalPlays = rivalPlay
                    )
                )
            }
        }
        else if (rivalPlay == Plays.PAPER || rivalPlay == Plays.SPOCK) {
            rival.hasLostRound()
            if (rival.lostRounds >= 3) {
                navController.navigate(EndOfGameScreenDestiny(rival))
            } else {
                navController.navigate(
                    route = EndOfRoundScreenDestiny(
                        rival = rival,
                        yourPlay = yourPlay,
                        rivalPlays = rivalPlay
                    )
                )
            }
        }
        else {
            navController.navigate(
                route = EndOfRoundScreenDestiny(
                    rival = rival,
                    yourPlay = yourPlay,
                    rivalPlays = rivalPlay
                )
            )
        }
    }
    else if (yourPlay == Plays.SPOCK) {
        if (rivalPlay == Plays.PAPER || rivalPlay == Plays.LIZARD) {
            rival.hasWonRound()
            if (rival.wonRounds >= 3) {
                navController.navigate(EndOfGameScreenDestiny(rival))
            } else {
                navController.navigate(
                    route = EndOfRoundScreenDestiny(
                        rival = rival,
                        yourPlay = yourPlay,
                        rivalPlays = rivalPlay
                    )
                )
            }
        }
        else if (rivalPlay == Plays.ROCK || rivalPlay == Plays.SCISSORS) {
            rival.hasLostRound()
            if (rival.lostRounds >= 3) {
                navController.navigate(EndOfGameScreenDestiny(rival))
            } else {
                navController.navigate(
                    route = EndOfRoundScreenDestiny(
                        rival = rival,
                        yourPlay = yourPlay,
                        rivalPlays = rivalPlay
                    )
                )
            }
        }
        else {
            navController.navigate(
                route = EndOfRoundScreenDestiny(
                    rival = rival,
                    yourPlay = yourPlay,
                    rivalPlays = rivalPlay
                )
            )
        }
    }
    else if (yourPlay == Plays.LIZARD) {
        if (rivalPlay == Plays.SCISSORS || rivalPlay == Plays.ROCK) {
            rival.hasWonRound()
            if (rival.wonRounds >= 3) {
                navController.navigate(EndOfGameScreenDestiny(rival))
            } else {
                navController.navigate(
                    route = EndOfRoundScreenDestiny(
                        rival = rival,
                        yourPlay = yourPlay,
                        rivalPlays = rivalPlay
                    )
                )
            }
        }
        else if (rivalPlay == Plays.PAPER || rivalPlay == Plays.SPOCK) {
            rival.hasLostRound()
            if (rival.lostRounds >= 3) {
                navController.navigate(EndOfGameScreenDestiny(rival))
            } else {
                navController.navigate(
                    route = EndOfRoundScreenDestiny(
                        rival = rival,
                        yourPlay = yourPlay,
                        rivalPlays = rivalPlay
                    )
                )
            }
        }
        else {
            navController.navigate(
                route = EndOfRoundScreenDestiny(
                    rival = rival,
                    yourPlay = yourPlay,
                    rivalPlays = rivalPlay
                )
            )
        }
    }
}
//endregion
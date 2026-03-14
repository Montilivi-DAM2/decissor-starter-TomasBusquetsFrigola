package org.es.tomas.pedra_paper_tisores.ui.Navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.es.tomas.pedra_paper_tisores.ui.Screens.EndOfGameScreen
import org.es.tomas.pedra_paper_tisores.ui.Screens.EndOfRoundScreen
import org.es.tomas.pedra_paper_tisores.ui.Screens.HomePage
import org.es.tomas.pedra_paper_tisores.ui.Screens.RockPaperScissors

@Composable
fun navigationGraf(
    navigationController: NavHostController = rememberNavController(),
    paddingValues: PaddingValues =PaddingValues(0.dp)
) {
    NavHost(
        navController =navigationController,
        startDestination = HomePageDestiny,
        modifier = Modifier.padding(paddingValues)
    ) {
        composable<HomePageDestiny> {
            HomePage()
        }
        composable<GameScreenDestiny> {
            RockPaperScissors(
                rival = TODO()
            )
        }
        composable<EndOfRoundScreenDestiny> {
            EndOfRoundScreen(
                rival = TODO(),
                yourPlay = TODO(),
                rivalPlay = TODO()
            )
        }
        composable<EndOfGameScreenDestiny> {
            EndOfGameScreen(
                rival = TODO()
            )
        }
    }
}
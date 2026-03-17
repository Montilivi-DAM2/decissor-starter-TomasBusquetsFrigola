package org.es.tomas.pedra_paper_tisores.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import org.es.tomas.pedra_paper_tisores.Model.DataStorage.MyPreferencesDataStore
import org.es.tomas.pedra_paper_tisores.ui.Navigation.EndOfGameScreenDestiny
import org.es.tomas.pedra_paper_tisores.ui.Navigation.EndOfRoundScreenDestiny
import org.es.tomas.pedra_paper_tisores.ui.Navigation.HomePageDestiny
import org.es.tomas.pedra_paper_tisores.ui.Navigation.PreferencesScreenDestiny
import org.es.tomas.pedra_paper_tisores.ui.Navigation.RockPaperScissorsDestiny
import org.es.tomas.pedra_paper_tisores.ui.Navigation.navigationGraf

val localPreferences = staticCompositionLocalOf<MyPreferencesDataStore> {
    error("ERROR: NO PREFERENCE DATASTORE PROVIDED!")
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun App(
    navigationController: NavHostController
){
    val context = LocalContext.current
    val preferences = remember { MyPreferencesDataStore(context.applicationContext) }

    val navState = navigationController.currentBackStackEntryAsState()
    val currentDestination = navState.value?.destination

    val isHome = currentDestination?.hasRoute(HomePageDestiny::class) ?: false
    val isPlaying = currentDestination?.hasRoute(RockPaperScissorsDestiny::class) ?: false
    val isAtRoundsEnd = currentDestination?.hasRoute(EndOfRoundScreenDestiny::class) ?: false
    val isAtGamesEnd = currentDestination?.hasRoute(EndOfGameScreenDestiny::class) ?: false
    val isAtPreferences = currentDestination?.hasRoute(PreferencesScreenDestiny::class) ?: false

    CompositionLocalProvider(
        value = localPreferences provides preferences
    ) {
        Scaffold(
            modifier = Modifier
                .fillMaxSize(),
            topBar = {
                TopAppBar(
                    title = {
                        Text(
                            text =
                                if (isHome) "HOME"
                                else if (isPlaying) "DUEL"
                                else if (isAtRoundsEnd) "ROUND'S RESULT"
                                else if (isAtGamesEnd) "GAME'S RESULT:"
                                else if (isAtPreferences) "SETTINGS"
                                else "404 UNDEFINED",
                            style = MaterialTheme.typography.displaySmall,
                            color = MaterialTheme.colorScheme.onPrimary
                        )
                    },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = MaterialTheme.colorScheme.primaryContainer,
                        navigationIconContentColor = MaterialTheme.colorScheme.onPrimaryContainer
                    )
                )
            }
        ) {
            navigationGraf(
                navigationController = navigationController,
                paddingValues = it
            )
        }
    }
}
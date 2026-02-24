package org.es.tomas.practica_viewmodel.ui.Navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun navGraf (
    navController: NavHostController = rememberNavController(),
    paddingValues: PaddingValues = PaddingValues(0.dp)
) {
    NavHost(
        navController = navController,
        startDestination = HomePageDestiny,
        modifier = Modifier.padding(paddingValues)
    ) {
        composable<HomePageDestiny> {

        }

        composable<GameScreenDestiny> {

        }

        composable<EndOfGameDestiny> {

        }
    }
}
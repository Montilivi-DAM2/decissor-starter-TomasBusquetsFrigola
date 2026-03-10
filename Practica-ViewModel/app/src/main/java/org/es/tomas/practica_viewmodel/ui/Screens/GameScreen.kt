package org.es.tomas.practica_viewmodel.ui.Screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import org.es.tomas.practica_viewmodel.model.Jugador
import org.es.tomas.practica_viewmodel.ui.Viewmodels.GameScreenState
import org.es.tomas.practica_viewmodel.ui.Viewmodels.GameScreenViewModel

@SuppressLint("UnrememberedMutableState")
@Preview
@Composable
fun gameScreen(
    viewModel: GameScreenViewModel = viewModel()
) {
    val _state by mutableStateOf(GameScreenState())
    Column(
        Modifier
            .fillMaxSize()
            .padding(32.dp)
    ) {

    }
}
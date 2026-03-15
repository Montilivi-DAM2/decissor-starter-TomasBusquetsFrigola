package org.es.tomas.practica_viewmodel.ui.Viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.es.tomas.practica_viewmodel.model.Enums.Jugades

class GameScreenViewModel: ViewModel() {
    var state by mutableStateOf(GameScreenState())

    init {
        state = GameScreenState(
            deciding = false,
            play = Jugades.PEDRA
        )
    }

    fun decidePlay (waitTime: Long) {
        state = state.copy(deciding = true)
        viewModelScope.launch (Dispatchers.IO) {
            delay(waitTime)
            state = state.copy(play = Jugades.values().toList().shuffled().first())
        }
    }

//    fun gameResult
}

data class GameScreenState(
    val deciding: Boolean = false,
    val play: Jugades = Jugades.PEDRA
)
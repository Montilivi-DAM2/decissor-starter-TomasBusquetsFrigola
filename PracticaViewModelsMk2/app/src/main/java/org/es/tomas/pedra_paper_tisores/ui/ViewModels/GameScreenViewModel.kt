package org.es.tomas.pedra_paper_tisores.ui.ViewModels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.es.tomas.pedra_paper_tisores.Model.Enums.Plays

class GameScreenViewModel: ViewModel() {
    var state by mutableStateOf(GameScreenState())
        private set

    init {
        state = GameScreenState(
            result = Plays.ROCK,
            deciding = false
        )
    }

    fun decide(waitTime: Long) {
        state = state.copy(deciding = true)
        viewModelScope.launch(Dispatchers.IO) {
            state = state.copy(result = Plays.ROCK)
            delay(waitTime)
            state = state.copy(
                result = Plays.values().random(),
                deciding = false
            )
        }
    }
}

data class GameScreenState(
    val deciding: Boolean = false,
    val result: Plays = Plays.ROCK
)
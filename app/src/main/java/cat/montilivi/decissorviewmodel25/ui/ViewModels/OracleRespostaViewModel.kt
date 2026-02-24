package cat.montilivi.decissorviewmodel25.ui.ViewModels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.toRoute
import androidx.savedstate.savedState
import cat.institutmontivi.decissorviewmodel25.navegacio.DestinacioOracleResposta
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

//private val OracleRespostaViewModel.stateViewHandle: Any

class OracleRespostaViewModel(
    savedStateHandle: SavedStateHandle
): ViewModel() {
    var estat by mutableStateOf(OracleRespostaEstat())
        private set

    init {
        val arg = savedStateHandle.toRoute<DestinacioOracleResposta>()
        estat = estat.copy(
            pregunta = arg.pregunta,
            resposta = ""
        )
    }

    val respostes = listOf (
        "Si",
        "No",
        "Qui sap",
        "Potser si",
        "Perquè no",
        "Aisò no to creus ni tu",
        "I a mi que em preguntes!?"
    )

    fun respon (  ) {
        viewModelScope.launch {
            delay(500L)
            estat = estat.copy(
                resposta = respostes.random()
            )
        }
    }
}

data class OracleRespostaEstat (
    val pregunta: String = "",
    val resposta: String = ""
)
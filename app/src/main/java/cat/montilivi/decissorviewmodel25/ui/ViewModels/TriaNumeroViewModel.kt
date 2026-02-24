package cat.montilivi.decissorviewmodel25.ui.ViewModels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class TriaNumeroViewModel: ViewModel() {
    var estat by mutableStateOf(TriaNumeroEstat())
        private set
    init {
        estat = TriaNumeroEstat (
            numMinim = 0,
            numMaxim = 999,
            resultat = 555,
            sortejant = false
        )
    }

    fun sortejaNumero (
        minim: Int,
        maxim: Int,
        tempsEspera: Long
    ) {
        viewModelScope.launch {
            estat = estat.copy(
                numMinim = minim,
                numMaxim = maxim,
                tempsEspera = tempsEspera,
                sortejant = true
            )
            delay(tempsEspera)
            estat = estat.copy(
                resultat = (minim..maxim).random(),
                sortejant = false
            )
        }
    }
}

data class TriaNumeroEstat (
    val numMinim: Int = 0,
    val numMaxim: Int = 9,
    val resultat: Int = 555,
    val sortejant: Boolean = false,
    val tempsEspera: Long = 5
)
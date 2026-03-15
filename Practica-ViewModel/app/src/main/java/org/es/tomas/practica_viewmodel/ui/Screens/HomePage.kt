package org.es.tomas.practica_viewmodel.ui.Screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.es.tomas.practica_viewmodel.model.Classes.Data
import org.es.tomas.practica_viewmodel.model.Enums.Noms

@Preview
@Composable
fun homePage (
    onClick: () -> Unit = {}
) {
    val data: Data = Data()
    var nEliminats = 0

    (0..10).forEach { i ->
        val names = Noms.values().toList().shuffled()
        data.crearJugador(names[i].toString())
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.surfaceVariant)
            .padding(48.dp)
    ) {

        Text(
            text = "Eliminats: $nEliminats",
        )
        Spacer(Modifier.padding(25.dp))
        if (nEliminats < data.jugadors.size) {
            Text("Ononent: ${data.jugadors[nEliminats]}")
        }

        Button(
            onClick = {

            },
            Modifier
                .size(50.dp)
        ) {
            Text("JUGAR")
        }
    }
}
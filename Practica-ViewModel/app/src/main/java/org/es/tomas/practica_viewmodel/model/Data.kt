package org.es.tomas.practica_viewmodel.model

class Data(
    val jugadors: MutableList<Jugador> = mutableListOf()
) {
    fun crearJugador(nom: String) {
        val jugador = Jugador(nom)
        jugadors.add(jugador)
    }

    fun reset() {
        jugadors.removeAll(elements = jugadors)
    }
}
package org.es.tomas.practica_viewmodel.model

class Data(
    val jugadors: MutableList<Jugador> = mutableListOf()
) {
    fun creaJugador(){

    }

    fun reset() {
        this.jugadors.removeAll(jugadors)
    }
}
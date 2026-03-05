package org.es.tomas.practica_viewmodel.model

class Jugador(
    val nom: String,
    var rondesGuanyades: Int,
    var rondesPerdudes: Int
) {
    fun incrementaGuanyades() {
        this.rondesGuanyades++
    }

    fun incrementaPerdudes() {
        this.rondesPerdudes++
    }
}
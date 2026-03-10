package org.es.tomas.practica_viewmodel.model

class Jugador(
    val nom: String,
    var rondesGuanyades: Int = 0,
    var rondesPerdudes: Int = 0
) {
    fun incrementaGuanyades() {
        this.rondesGuanyades++
    }

    fun incrementaPerdudes() {
        this.rondesPerdudes++
    }
}
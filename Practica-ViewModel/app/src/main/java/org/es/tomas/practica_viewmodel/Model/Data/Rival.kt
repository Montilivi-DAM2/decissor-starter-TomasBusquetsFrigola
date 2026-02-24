package org.es.tomas.practica_viewmodel.Model.Data

data class Rival (
    val id: Int,
    val name: String,
    var defeated: Boolean = false
)
package org.es.tomas.practica_viewmodel.Model.Data

import org.es.tomas.practica_viewmodel.Model.Implementations.DAORivalImpl

data class GameData(
    var nRivalsDefeated: Int
) {
    fun victory () {
        nRivalsDefeated++
    }

    fun gameReset () {
        val dao = DAORivalImpl()
        dao.rivals.forEach { rival ->
            rival.defeated = false
        }
    }
}

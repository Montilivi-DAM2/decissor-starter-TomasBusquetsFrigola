package org.es.tomas.pedra_paper_tisores.Model

import org.es.tomas.pedra_paper_tisores.Model.Enums.Names

class Data {
    val players: MutableList<Player> = mutableListOf()

    fun createPlayer() {
        val names = Names.values().toList().shuffled().random().toString()
        (0..names.length).forEach { name ->
            val newPlayer = Player(
                name = name.toString()
            )
            players.add(newPlayer)
        }
    }

    fun reset(){
        players.removeAll(players)
    }
}
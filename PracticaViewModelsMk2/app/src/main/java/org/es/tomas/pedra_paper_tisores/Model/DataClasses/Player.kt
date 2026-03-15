package org.es.tomas.pedra_paper_tisores.Model.DataClasses

data class Player(
    val name: String,
    var wonRounds: Int = 0,
    var lostRounds: Int = 0
) {
    fun hasWonRound(){
        this.wonRounds++
    }

    fun hasLostRound(){
        this.lostRounds++
    }

//    fun getName(): String {
//        return this.name
//    }

    override fun toString(): String {
        return "${name}\nWINRATE: ${wonRounds}       LOSSRATE: ${lostRounds}"
    }
}

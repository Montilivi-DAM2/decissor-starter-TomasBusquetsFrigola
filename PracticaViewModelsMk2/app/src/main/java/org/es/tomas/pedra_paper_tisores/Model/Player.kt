package org.es.tomas.pedra_paper_tisores.Model

data class Player(
    val name: String,
    var roundsPlayed: Int = 0,
    var wonRounds: Int = 0,
    var lostRounds: Int = 0
) {
    fun hasPlayedRound(){
        this.roundsPlayed++
    }

    fun hasWonRound(){
        hasPlayedRound()
        this.wonRounds++
    }

    fun hasLostRound(){
        hasPlayedRound()
        this.lostRounds++
    }
}

package org.es.tomas.pedra_paper_tisores.ui.Navigation

import kotlinx.serialization.Serializable
import org.es.tomas.pedra_paper_tisores.Model.Enums.Plays
import org.es.tomas.pedra_paper_tisores.Model.Player

@Serializable
object HomePageDestiny

@Serializable
data class RockPaperScissorsDestiny (val rival: Player)

@Serializable
data class EndOfRoundScreenDestiny (
    val rival: Player,
    val yourPlay: Plays,
    val rivalPlays: Plays
)

@Serializable
data class EndOfGameScreenDestiny (val rival: Player)
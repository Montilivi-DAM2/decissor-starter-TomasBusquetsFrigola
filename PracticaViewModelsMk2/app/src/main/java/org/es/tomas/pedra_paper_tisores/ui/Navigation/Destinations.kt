package org.es.tomas.pedra_paper_tisores.ui.Navigation

import kotlinx.serialization.Serializable
import org.es.tomas.pedra_paper_tisores.Model.Enums.Plays
import org.es.tomas.pedra_paper_tisores.Model.DataClasses.Player

@Serializable
object HomePageDestiny

@Serializable
data class RockPaperScissorsDestiny(val player: Player)

@Serializable
data class EndOfRoundScreenDestiny(val player: Player, val yourPlay: Plays, val hisPlay: Plays)

@Serializable
data class EndOfGameScreenDestiny(val player: Player)

@Serializable
data class PreferencesScreenDestiny(val player: Player)
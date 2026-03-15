package org.es.tomas.pedra_paper_tisores.Model.DataClasses

class Data {
    val players: MutableList<Player> = mutableListOf()
    val names = listOf("ADAM, ADRIAN, ALICE, AMANDA, AMY,\n" +
            "    ANDREW, ANGELA, ARTHUR, AUSTIN, BEATRICE,\n" +
            "    BENJAMIN, CATHERINE, CHARLES, CHLOE, CONNOR,\n" +
            "    DANIEL, DAVID, DIANA, DOROTHY, EDWARD,\n" +
            "    ELIZABETH, ELLIOT, EMILY, ETHAN, FELICITY,\n" +
            "    FIONA, GEORGE, GRACE, HANNAH, HAROLD,\n" +
            "    ISAAC, ISABELLA, JACK, JACOB, JESSICA,\n" +
            "    JOSEPH, JULIA, KEVIN, LAURA, LAWRENCE,\n" +
            "    MARCUS, MARGARET, MATTHEW, NAOMI, NATHAN,\n" +
            "    OLIVER, OLIVIA, PENELOPE, QUENTIN, RACHEL")

    fun createPlayer() {
        (0..<names.size).forEach { name ->
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
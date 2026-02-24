package org.es.tomas.practica_viewmodel.Model.Implementations

import org.es.tomas.practica_viewmodel.Model.Data.Rival
import org.es.tomas.practica_viewmodel.Model.Interfaces.DAORival

class DAORivalImpl: DAORival {
    override fun updateRival(rival: Rival): Boolean {
        val index: Int = rivals.indexOfFirst { it.id == rival.id }
        if (index < 0) return false
        rivals[index] = rival
        return true
    }

    override fun insertRival(rival: Rival): Boolean {
        if (rivals.indexOfFirst { it.id == rival.id } >= 0) return false
        rivals.add(rival)
        return true
    }

    override fun deleteRival(rivalId: Int): Boolean {
        val index = rivals.indexOfFirst { it.id == rivalId }
        if (index < 0) return false
        rivals.removeAt(index)
        return true
    }

    override fun getRival(rivalId: Int): Rival? {
        return rivals.firstOrNull{ rival -> rival.id == rivalId }
    }

    override fun getAll(): List<Rival> {
        return rivals.toList()
    }

    val rivals = mutableListOf<Rival>(
        Rival(id = 1, name = "Astra Vance", defeated = false),
        Rival(id = 2, name = "Blake Rourke", defeated = false),
        Rival(id = 3, name = "Cora Nyx", defeated = false),
        Rival(id = 4, name = "Dante Kessler", defeated = false),
        Rival(id = 5, name = "Elara Quinn", defeated = false),
        Rival(id = 6, name = "Felix Dray", defeated = false),
        Rival(id = 7, name = "Gwen Ashford", defeated = false),
        Rival(id = 8, name = "Hugo Mercer", defeated = false),
        Rival(id = 9, name = "Iris Lockhart", defeated = false),
        Rival(id = 10, name = "Jax Calder", defeated = false),
        Rival(id = 11, name = "Kaia Wren", defeated = false),
        Rival(id = 12, name = "Luca Vesper", defeated = false),
        Rival(id = 13, name = "Mara Sable", defeated = false),
        Rival(id = 14, name = "Nolan Pike", defeated = false),
        Rival(id = 15, name = "Opal Fenwick", defeated = false),
        Rival(id = 16, name = "Porter Blackwell", defeated = false),
        Rival(id = 17, name = "Rhea Thorn", defeated = false),
        Rival(id = 18, name = "Silas Crowe", defeated = false),
        Rival(id = 19, name = "Talia Marlowe", defeated = false),
        Rival(id = 20, name = "Viktor Hale", defeated = false),
        Rival(id = 21, name = "Willa Sterling", defeated = false),
        Rival(id = 22, name = "Xander Vale", defeated = false),
        Rival(id = 23, name = "Yara Whitlock", defeated = false),
        Rival(id = 24, name = "Zane Hardwick", defeated = false),
        Rival(id = 25, name = "Adrian Knox", defeated = false),
        Rival(id = 26, name = "Bianca Frost", defeated = false),
        Rival(id = 27, name = "Cassian Drake", defeated = false),
        Rival(id = 28, name = "Delilah Storm", defeated = false),
        Rival(id = 29, name = "Elias Grimshaw", defeated = false),
        Rival(id = 30, name = "Freya Nightingale", defeated = false),
        Rival(id = 31, name = "Gideon Cross", defeated = false),
        Rival(id = 32, name = "Helena Graves", defeated = false),
        Rival(id = 33, name = "Isaac Redmond", defeated = false),
        Rival(id = 34, name = "Juno Carver", defeated = false),
        Rival(id = 35, name = "Kieran Wolfe", defeated = false),
        Rival(id = 36, name = "Lyra Ravenswood", defeated = false),
        Rival(id = 37, name = "Magnus Rowe", defeated = false),
        Rival(id = 38, name = "Naomi Black", defeated = false),
        Rival(id = 39, name = "Orion Fletcher", defeated = false),
        Rival(id = 40, name = "Penelope Shaw", defeated = false),
        Rival(id = 41, name = "Quentin Rusk", defeated = false),
        Rival(id = 42, name = "Rowan Sinclair", defeated = false),
        Rival(id = 43, name = "Selene Everhart", defeated = false),
        Rival(id = 44, name = "Tristan Voss", defeated = false),
        Rival(id = 45, name = "Uma Hart", defeated = false),
        Rival(id = 46, name = "Valeria Crane", defeated = false),
        Rival(id = 47, name = "Wyatt Slate", defeated = false),
        Rival(id = 48, name = "Xenia Wilder", defeated = false),
        Rival(id = 49, name = "Yves Lancaster", defeated = false),
        Rival(id = 50, name = "Zara Hawthorne", defeated = false)
    )
}
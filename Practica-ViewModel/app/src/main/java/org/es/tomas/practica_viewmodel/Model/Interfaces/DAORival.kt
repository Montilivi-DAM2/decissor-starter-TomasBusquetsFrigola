package org.es.tomas.practica_viewmodel.Model.Interfaces

import org.es.tomas.practica_viewmodel.Model.Data.Rival

interface DAORival {
    fun updateRival(rival: Rival): Boolean

    fun insertRival(rival: Rival): Boolean

    fun deleteRival(rivalId: Int): Boolean

    fun getRival(rivalId: Int): Rival?

    fun getAll(): List<Rival>
}
package org.es.tomas.pedra_paper_tisores.Model.DataStorage

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.map

class MyPreferencesDataStore(
    private val context: Context
) {
    companion object {
        private val Context.dataStore by preferencesDataStore("preferences")
        private val GAMEMODE = stringPreferencesKey("gamemode")
        private val NROUNDS = intPreferencesKey("nRounds")
        private val PLAYERNAME = stringPreferencesKey("playerName")
    }

    val getGamemode = context.dataStore.data.map { preferences ->
        preferences[GAMEMODE] ?: 0
    }

    val getNRounds = context.dataStore.data.map { preferences ->
        preferences[NROUNDS] ?: 0
    }

    val getPlayerName = context.dataStore.data.map { preferences ->
        preferences[PLAYERNAME] ?: 0
    }

    suspend fun setGamemode (gamemode: String) {
        context.dataStore.edit { preferences ->
            preferences[GAMEMODE] = gamemode
        }
    }

    suspend fun setMinNRounds (nRounds: Int) {
        context.dataStore.edit { preferences ->
            preferences[NROUNDS] = nRounds
        }
    }

    suspend fun setPlayerName (playerName: String) {
        context.dataStore.edit { preferences ->
            preferences[PLAYERNAME] = playerName
        }
    }
}
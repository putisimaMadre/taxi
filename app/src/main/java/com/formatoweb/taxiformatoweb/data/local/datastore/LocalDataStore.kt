package com.formatoweb.taxiformatoweb.data.local.datastore

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import com.formatoweb.taxiformatoweb.core.Config.AUTH_KEY
import com.formatoweb.taxiformatoweb.domain.model.AuthResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class LocalDataStore(private val dataStore: DataStore<Preferences>) {
    suspend fun save(authResponse: AuthResponse){
        val dataStoreKey = stringPreferencesKey(AUTH_KEY)
        dataStore.edit { preferences ->
            preferences[dataStoreKey] = authResponse.toJson()
        }
    }

    suspend fun delete(){
        val dataStoreKey = stringPreferencesKey(AUTH_KEY)
        dataStore.edit { preferences ->
            preferences.remove(dataStoreKey)
        }
    }

    fun getData(): Flow<AuthResponse>{
        val datastoreKey = stringPreferencesKey(AUTH_KEY)
        return dataStore.data.map { preferences ->
            if (preferences[datastoreKey] != null) {
                AuthResponse.fromJson(preferences[datastoreKey]!!)
            }else{
                AuthResponse()
            }
        }
    }
}
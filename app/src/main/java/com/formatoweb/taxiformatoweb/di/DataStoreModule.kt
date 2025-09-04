package com.formatoweb.taxiformatoweb.di

import android.content.Context
import android.preference.Preference
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStoreFile
import com.formatoweb.taxiformatoweb.core.Config.AUTH_PREF
import com.formatoweb.taxiformatoweb.data.local.datastore.LocalDataStore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataStoreModule {

    @Provides
    @Singleton
    fun providePreferenceDataStore(@ApplicationContext context: Context): DataStore<Preferences> =
        PreferenceDataStoreFactory.create (produceFile = {
            context.preferencesDataStoreFile(AUTH_PREF)
        }
        )

    @Provides
    fun provideLocalDataStore(dataStore: DataStore<Preferences>) = LocalDataStore(dataStore)
}
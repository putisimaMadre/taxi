package com.formatoweb.taxiformatoweb.di

import com.formatoweb.taxiformatoweb.data.local.datastore.LocalDataStore
import com.formatoweb.taxiformatoweb.data.remote.dataSource.remote.service.AuthService
import com.formatoweb.taxiformatoweb.data.remote.repository.AuthRespositoryImpl
import com.formatoweb.taxiformatoweb.domain.repository.AuthRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    fun provideAuthRepository(authService: AuthService, localDataStore: LocalDataStore): AuthRepository = AuthRespositoryImpl(authService, localDataStore)
}
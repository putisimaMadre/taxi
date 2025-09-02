package com.formatoweb.taxiformatoweb.di

import com.formatoweb.taxiformatoweb.data.dataSource.remote.service.AuthService
import com.formatoweb.taxiformatoweb.data.repository.AuthRespositoryImpl
import com.formatoweb.taxiformatoweb.domain.repository.AuthRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    fun provideAuthRepository(authService: AuthService): AuthRepository = AuthRespositoryImpl(authService)
}
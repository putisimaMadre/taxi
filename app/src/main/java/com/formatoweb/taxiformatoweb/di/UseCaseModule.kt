package com.formatoweb.taxiformatoweb.di

import com.formatoweb.taxiformatoweb.domain.repository.AuthRepository
import com.formatoweb.taxiformatoweb.domain.useCases.auth.AuthUseCases
import com.formatoweb.taxiformatoweb.domain.useCases.auth.LoginUseCase
import com.formatoweb.taxiformatoweb.domain.useCases.auth.RegisterUserCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    fun provideAuthUseCase(authRepository: AuthRepository) = AuthUseCases(
        login = LoginUseCase(authRepository),
        register = RegisterUserCase(authRepository)
    )
}
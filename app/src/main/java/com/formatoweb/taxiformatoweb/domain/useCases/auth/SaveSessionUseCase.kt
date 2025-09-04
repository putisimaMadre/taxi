package com.formatoweb.taxiformatoweb.domain.useCases.auth

import com.formatoweb.taxiformatoweb.domain.model.AuthResponse
import com.formatoweb.taxiformatoweb.domain.repository.AuthRepository

class SaveSessionUseCase(private val repository: AuthRepository) {
    suspend operator fun invoke(authResponse: AuthResponse) = repository.saveSession(authResponse)
}
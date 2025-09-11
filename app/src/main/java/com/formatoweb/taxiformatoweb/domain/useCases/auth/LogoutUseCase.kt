package com.formatoweb.taxiformatoweb.domain.useCases.auth

import com.formatoweb.taxiformatoweb.domain.repository.AuthRepository

class LogoutUseCase(private val repository: AuthRepository) {
    suspend operator fun invoke() = repository.logout()
}
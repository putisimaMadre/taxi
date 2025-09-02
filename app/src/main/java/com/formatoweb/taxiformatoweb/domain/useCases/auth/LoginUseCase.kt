package com.formatoweb.taxiformatoweb.domain.useCases.auth

import com.formatoweb.taxiformatoweb.domain.repository.AuthRepository

class LoginUseCase(private val repository: AuthRepository) {

    suspend operator fun invoke(email: String, password: String) = repository.login(email, password)
}
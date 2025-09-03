package com.formatoweb.taxiformatoweb.domain.useCases.auth

import com.formatoweb.taxiformatoweb.domain.model.User
import com.formatoweb.taxiformatoweb.domain.repository.AuthRepository

class RegisterUserCase(private val repository: AuthRepository) {
    suspend operator fun invoke(user: User) = repository.register(user)
}
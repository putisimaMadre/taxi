package com.formatoweb.taxiformatoweb.domain.useCases.auth

import com.formatoweb.taxiformatoweb.domain.repository.AuthRepository

class GetSessionDataUseCase(private val repository: AuthRepository) {
    operator fun invoke() = repository.getSessionData()
}
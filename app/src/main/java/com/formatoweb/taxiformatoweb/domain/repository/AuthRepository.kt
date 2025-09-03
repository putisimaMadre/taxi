package com.formatoweb.taxiformatoweb.domain.repository

import com.formatoweb.taxiformatoweb.domain.model.AuthResponse
import com.formatoweb.taxiformatoweb.domain.model.User
import com.formatoweb.taxiformatoweb.domain.util.Resource

interface AuthRepository {
    suspend fun login(email: String, password: String): Resource<AuthResponse>
    suspend fun register(user: User): Resource<AuthResponse>
}
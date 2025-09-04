package com.formatoweb.taxiformatoweb.domain.repository

import com.formatoweb.taxiformatoweb.domain.model.AuthResponse
import com.formatoweb.taxiformatoweb.domain.model.User
import com.formatoweb.taxiformatoweb.domain.util.Resource
import kotlinx.coroutines.flow.Flow

interface AuthRepository {
    suspend fun login(email: String, password: String): Resource<AuthResponse>
    suspend fun register(user: User): Resource<AuthResponse>
    suspend fun saveSession(authResponse: AuthResponse)
    suspend fun logout()
    fun getSessionData(): Flow<AuthResponse>
}
package com.formatoweb.taxiformatoweb.data.dataSource.remote.service

import com.formatoweb.taxiformatoweb.domain.model.AuthResponse
import com.formatoweb.taxiformatoweb.domain.model.LoginRequest
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface AuthService {

    @POST("auth/login")
    suspend fun login(
        @Body request: LoginRequest
    ): Response<AuthResponse>
}
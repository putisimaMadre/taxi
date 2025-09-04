package com.formatoweb.taxiformatoweb.data.remote.repository

import android.util.Log
import com.formatoweb.taxiformatoweb.data.local.datastore.LocalDataStore
import com.formatoweb.taxiformatoweb.data.remote.dataSource.remote.service.AuthService
import com.formatoweb.taxiformatoweb.domain.model.AuthResponse
import com.formatoweb.taxiformatoweb.domain.model.ErrorResponse
import com.formatoweb.taxiformatoweb.domain.model.LoginRequest
import com.formatoweb.taxiformatoweb.domain.model.User
import com.formatoweb.taxiformatoweb.domain.repository.AuthRepository
import com.formatoweb.taxiformatoweb.domain.util.ErrorHelper
import com.formatoweb.taxiformatoweb.domain.util.Resource
import kotlinx.coroutines.flow.Flow

class AuthRespositoryImpl(private val authService: AuthService, private val localDataStore: LocalDataStore): AuthRepository {
    override suspend fun login(
        email: String,
        password: String
    ): Resource<AuthResponse> {
        return try {
            val result = authService.login(LoginRequest(email, password))
            if (result.isSuccessful){
                Log.d("AuthRepositoryImpl", "Data Success: ${result.body()}")
                Resource.Success(result.body()!!)
            }else{
                Log.d("AuthRepositoryImpl", "Error en la peticion")
                val errorResponse: ErrorResponse? = ErrorHelper.handleError(result.errorBody())
                Resource.Failure(errorResponse?.message?: "Error en la desconocido")
            }
        }catch (e: Exception){
            Log.d("AuthRepositoryImpl", "Message: ${e}")
            Log.d("AuthRepositoryImpl", "Message Cause: ${e.cause}")
            e.printStackTrace()
            Resource.Failure(e.message ?: "Error desconocido")
        }
    }


    override suspend fun register(user: User): Resource<AuthResponse> {
        return try {
            val result = authService.register(user)
            if (result.isSuccessful){
                Log.d("AuthRepositoryImpl", "Data Success: ${result.body()}")
                Resource.Success(result.body()!!)
            }else{
                Log.d("AuthRepositoryImpl", "Error en la peticion")
                val errorResponse: ErrorResponse? = ErrorHelper.handleError(result.errorBody())
                Resource.Failure(errorResponse?.message?: "Error en la desconocido")
            }
        }catch (e: Exception){
            Log.d("AuthRepositoryImpl", "Message: ${e}")
            Log.d("AuthRepositoryImpl", "Message Cause: ${e.cause}")
            e.printStackTrace()
            Resource.Failure(e.message ?: "Error desconocido")
        }
    }

    override suspend fun saveSession(authResponse: AuthResponse) {
        localDataStore.save(authResponse)
    }

    override suspend fun logout() {
        localDataStore.delete()
    }

    override fun getSessionData(): Flow<AuthResponse> = localDataStore.getData()
}
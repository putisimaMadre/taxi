package com.formatoweb.taxiformatoweb.presentation.screens.auth.login

import android.util.Log
import android.util.Patterns
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.formatoweb.taxiformatoweb.domain.model.AuthResponse
import com.formatoweb.taxiformatoweb.domain.useCases.auth.AuthUseCases
import com.formatoweb.taxiformatoweb.domain.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val authUseCases: AuthUseCases): ViewModel() {
    var state by mutableStateOf(LoginState())
        private set

    var errorMessage by mutableStateOf("")

    var loginResponse by mutableStateOf<Resource<AuthResponse>?>(null)
        private set

    init {
        getSessionData()
    }

    fun onEmailInput(email: String){
        state = state.copy(email = email)
    }

    fun onPasswordInput(password: String){
        state = state.copy(password = password)
    }

    fun login() = viewModelScope.launch{
        if (isValidForm()){
            loginResponse = Resource.Loading
            val result = authUseCases.login(state.email, state.password)
            loginResponse = result //Success - Failure
        }
    }

    fun getSessionData() = viewModelScope.launch {
        authUseCases.getSessionData().collect { data ->
            Log.d("LoginViewModel", "Datos de sesion: ${data}")
            if (!data.token.isNullOrBlank()){
                loginResponse = Resource.Success(data)
            }
        }
    }

    fun saveSession(authResponse: AuthResponse) = viewModelScope.launch {
        authUseCases.saveSession(authResponse)
    }

    fun isValidForm(): Boolean{
        errorMessage = ""

        if (state.email.isEmpty()){
            errorMessage = "Ingresa el e-mail"
            return false
        }
        else if (state.password.isEmpty()){
            errorMessage = "Ingresa el password"
            return false
        }
        else if (!Patterns.EMAIL_ADDRESS.matcher(state.email).matches()){
            errorMessage = "El email no es valido"
            return false
        }
        else if (state.password.length < 6){
            errorMessage = "El password debe de tener al menos 6 caracteres"
            return false
        }
        return true
    }
}
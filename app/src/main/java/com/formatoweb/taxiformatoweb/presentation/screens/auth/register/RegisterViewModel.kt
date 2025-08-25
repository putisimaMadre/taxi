package com.formatoweb.taxiformatoweb.presentation.screens.auth.register

import android.util.Log
import android.util.Patterns
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlin.math.log

@HiltViewModel
class RegisterViewModel @Inject constructor(): ViewModel(){
    var state by mutableStateOf(RegisterState())
        private set

    var errorMessage by mutableStateOf("")

    fun register(){
        if (isValidForm()){
            Log.d("RegisterViewModel", "Name: ${state.name}")
            Log.d("RegisterViewModel", "Name: ${state.lastName}")
            Log.d("RegisterViewModel", "Name: ${state.phone}")
            Log.d("RegisterViewModel", "Name: ${state.email}")
            Log.d("RegisterViewModel", "Name: ${state.password}")
            Log.d("RegisterViewModel", "Name: ${state.confirmPassword}")
        }
    }

    fun onNameInput(name: String){
        state = state.copy(name = name)
    }

    fun onLastnameInput(lastname: String){
        state = state.copy(lastName = lastname)
    }

    fun onEmailInput(email: String){
        state = state.copy(email = email)
    }

    fun onPhoneInput(phone: String){
        state = state.copy(phone = phone)
    }

    fun onPasswordInput(password: String){
        state = state.copy(password = password)
    }

    fun onConfirmPasswordInput(confirmPassword: String){
        state = state.copy(confirmPassword = confirmPassword)
    }

    fun isValidForm(): Boolean {
        errorMessage = ""
        if (state.name.isEmpty()){
            errorMessage = "Ingresa el nombre"
            return false
        }
        else if (state.lastName.isEmpty()){
            errorMessage = "Ingresa el apellido"
            return false
        }
        else if (state.email.isEmpty()){
            errorMessage = "Ingresa el correo electronico"
            return false
        }
        else if (state.phone.isEmpty()){
            errorMessage = "Ingresa el telefono"
            return false
        }
        else if (state.password.isEmpty()){
            errorMessage = "Ingresa el password"
            return false
        }
        else if (state.confirmPassword.isEmpty()){
            errorMessage = "Ingresa el password de confirmacion"
            return false
        }
        else if (!Patterns.EMAIL_ADDRESS.matcher(state.email).matches()){
            errorMessage = "El email no es valido"
            return false
        }
        else if (state.password.length < 6){
            errorMessage = "El password debe tener almenos 6 caracteres"
            return false
        }
        else if (state.password != state.confirmPassword){
            errorMessage = "Los passwords no coinciden"
            return false
        }
        return true
    }
}
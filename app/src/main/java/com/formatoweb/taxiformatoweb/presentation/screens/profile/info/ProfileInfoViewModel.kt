package com.formatoweb.taxiformatoweb.presentation.screens.profile.info

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.formatoweb.taxiformatoweb.domain.model.User
import com.formatoweb.taxiformatoweb.domain.useCases.auth.AuthUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileInfoViewModel @Inject constructor (private val authUseCases: AuthUseCases): ViewModel() {
    var user by mutableStateOf<User?>(null)
        private set

    init {
        getSessionData()
    }

    fun getSessionData() = viewModelScope.launch {
        authUseCases.getSessionData().collect() { data ->
            user = data.user
        }
    }

    fun logout() = viewModelScope.launch {
        authUseCases.logout()
    }
}
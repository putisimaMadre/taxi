package com.formatoweb.taxiformatoweb.presentation.screens.auth.login.components

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import com.formatoweb.taxiformatoweb.domain.util.Resource
import com.formatoweb.taxiformatoweb.presentation.components.ProgressBar
import com.formatoweb.taxiformatoweb.presentation.screens.auth.login.LoginViewModel

@Composable
fun Login(viewModel: LoginViewModel = hiltViewModel()) {
    val context = LocalContext.current
    when(val response = viewModel.loginResponse){
        Resource.Loading -> {
            ProgressBar()
        }
        is Resource.Success -> {
            Toast.makeText(context, "Login exitoso", Toast.LENGTH_SHORT).show()
        }
        is Resource.Failure -> {
            Toast.makeText(context, response.message, Toast.LENGTH_SHORT).show()
        }
        else -> {
            if (response != null){
                Toast.makeText(context, "Hubo un error desconocido", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
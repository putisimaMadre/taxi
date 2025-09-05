package com.formatoweb.taxiformatoweb.presentation.screens.auth.register.components

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.formatoweb.taxiformatoweb.domain.util.Resource
import com.formatoweb.taxiformatoweb.presentation.components.ProgressBar
import com.formatoweb.taxiformatoweb.presentation.navigation.Graph
import com.formatoweb.taxiformatoweb.presentation.screens.auth.login.LoginViewModel
import com.formatoweb.taxiformatoweb.presentation.screens.auth.register.RegisterViewModel

@Composable
fun Register(navHostController: NavHostController, viewModel: RegisterViewModel = hiltViewModel()) {

    var context = LocalContext.current

    when(val response = viewModel.registerResponse){
        Resource.Loading -> {
            ProgressBar()
        }
        is Resource.Success -> {
            LaunchedEffect(Unit) {
                viewModel.saveSession(response.data)
                navHostController.navigate(route = Graph.CLIENT){
                    popUpTo (Graph.AUTH) {inclusive = true}
                }
            }
        }
        is Resource.Failure -> {
            Toast.makeText(context, response.message, Toast.LENGTH_LONG).show()
        }
        else -> {
            if (response != null){
                Toast.makeText(context, "Error desconocido", Toast.LENGTH_LONG).show()
            }
        }
    }
}
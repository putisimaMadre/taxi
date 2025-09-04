package com.formatoweb.taxiformatoweb.presentation.navigation.graph.auth

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.formatoweb.taxiformatoweb.presentation.navigation.Graph
import com.formatoweb.taxiformatoweb.presentation.navigation.graph.client.ClientNavGraph
import com.formatoweb.taxiformatoweb.presentation.navigation.graph.screen.auth.AuthScreen
import com.formatoweb.taxiformatoweb.presentation.screens.auth.login.LoginScreen
import com.formatoweb.taxiformatoweb.presentation.screens.auth.register.RegisterScreen

fun NavGraphBuilder.AuthNavGraph(navHostController: NavHostController) {
    navigation(
        route = Graph.AUTH,
        startDestination = AuthScreen.Login.route
    ){
        composable (route = AuthScreen.Login.route){LoginScreen(navHostController)}
        composable (route = AuthScreen.Register.route){ RegisterScreen(navHostController)
        }
        ClientNavGraph(navHostController)
    }
}
package com.formatoweb.taxiformatoweb.presentation.navigation.graph.client

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.formatoweb.taxiformatoweb.presentation.navigation.Graph
import com.formatoweb.taxiformatoweb.presentation.navigation.graph.screen.auth.AuthScreen
import com.formatoweb.taxiformatoweb.presentation.navigation.screen.client.ClientScreen
import com.formatoweb.taxiformatoweb.presentation.screens.auth.login.LoginScreen
import com.formatoweb.taxiformatoweb.presentation.screens.auth.register.RegisterScreen
import com.formatoweb.taxiformatoweb.presentation.screens.client.home.ClientHomeScreen

fun NavGraphBuilder.ClientNavGraph(navHostController: NavHostController) {
    navigation(
        route = Graph.CLIENT,
        startDestination = ClientScreen.Home.route
    ){
        composable (route = ClientScreen.Home.route){ClientHomeScreen(navHostController = navHostController)}
    }
}

/*fun ClientNavGraph(navHostController: NavHostController){
    NavHost(
        navHostController,
        graph = Graph.CLIENT,
        startDestination = ClientScreen.Home.route
    ){
        composable(route = ClientScreen.Home.route){
            ClientHomeScreen(navHostController = navHostController)
        }
    }
}*/
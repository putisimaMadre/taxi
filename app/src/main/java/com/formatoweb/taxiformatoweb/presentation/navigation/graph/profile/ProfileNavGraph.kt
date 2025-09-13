package com.formatoweb.taxiformatoweb.presentation.navigation.graph.profile

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.formatoweb.taxiformatoweb.presentation.navigation.Graph
import com.formatoweb.taxiformatoweb.presentation.navigation.graph.client.ClientNavGraph
import com.formatoweb.taxiformatoweb.presentation.navigation.graph.screen.auth.AuthScreen
import com.formatoweb.taxiformatoweb.presentation.navigation.screen.profile.ProfileScreen
import com.formatoweb.taxiformatoweb.presentation.screens.auth.login.LoginScreen
import com.formatoweb.taxiformatoweb.presentation.screens.auth.register.RegisterScreen
import com.formatoweb.taxiformatoweb.presentation.screens.client.home.ClientHomeScreen
import com.formatoweb.taxiformatoweb.presentation.screens.profile.info.ProfileInfoScreen
import com.formatoweb.taxiformatoweb.presentation.screens.profile.update.ProfileUpdateScreen

fun NavGraphBuilder.ProfileNavGraph(navHostController: NavHostController) {
    navigation(
        route = Graph.PROFILE,
        startDestination = ProfileScreen.ProfileInfo.route
    ){
        composable (route = ProfileScreen.ProfileInfo.route){ ProfileInfoScreen(navHostController = navHostController) }
        composable (
            route = ProfileScreen.ProfileUpdate.route,
            arguments = listOf(navArgument("user"){
                type = NavType.StringType
            })
        ){
            it.arguments?.getString("user")?.let {user ->
                ProfileUpdateScreen(navHostController = navHostController, userParam = user)
            }
        }
    }
}
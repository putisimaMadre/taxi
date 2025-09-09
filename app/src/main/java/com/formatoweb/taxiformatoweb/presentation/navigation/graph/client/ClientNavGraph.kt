package com.formatoweb.taxiformatoweb.presentation.navigation.graph.client

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.formatoweb.taxiformatoweb.presentation.navigation.Graph
import com.formatoweb.taxiformatoweb.presentation.navigation.screen.client.ClientScreen
import com.formatoweb.taxiformatoweb.presentation.screens.client.mapSearcher.ClientMapSearcherScreen
import com.formatoweb.taxiformatoweb.presentation.screens.profile.info.ProfileInfoScreen

@Composable
fun ClientNavGraph(navHostController: NavHostController) {
    NavHost(
        navController = navHostController,
        route = Graph.CLIENT,
        startDestination = ClientScreen.MapSearcher.route
    ){
        composable (route = ClientScreen.ProfileInfo.route){ ProfileInfoScreen(navHostController = navHostController)}
        composable (route = ClientScreen.MapSearcher.route){ ClientMapSearcherScreen(navHostController = navHostController) }
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
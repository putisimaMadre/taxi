package com.formatoweb.taxiformatoweb.presentation.navigation.graph.root

import android.widget.MediaController
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.formatoweb.taxiformatoweb.presentation.navigation.Graph
import com.formatoweb.taxiformatoweb.presentation.navigation.graph.auth.AuthNavGraph

@Composable
fun RootNavGraph(navHostController: NavHostController) {
    NavHost(
        navController = navHostController,
        route = Graph.ROOT,
        startDestination = Graph.AUTH
    ){
        AuthNavGraph(navHostController)
    }
}
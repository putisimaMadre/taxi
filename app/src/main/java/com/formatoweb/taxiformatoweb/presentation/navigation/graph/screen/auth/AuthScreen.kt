package com.formatoweb.taxiformatoweb.presentation.navigation.graph.screen.auth


sealed class AuthScreen(val route: String) {
    object Login: AuthScreen(route = "/login")
    object Register: AuthScreen(route = "/register")
}
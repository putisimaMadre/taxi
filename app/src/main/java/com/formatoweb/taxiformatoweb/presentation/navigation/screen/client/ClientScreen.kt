package com.formatoweb.taxiformatoweb.presentation.navigation.screen.client

sealed class ClientScreen(val route: String) {
    object Home: ClientScreen("/client/home")
}
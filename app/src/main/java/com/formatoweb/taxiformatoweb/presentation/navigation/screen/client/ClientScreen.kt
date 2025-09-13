package com.formatoweb.taxiformatoweb.presentation.navigation.screen.client

sealed class ClientScreen(val route: String) {
    object MapSearcher: ClientScreen("/client/map/searcher")
}
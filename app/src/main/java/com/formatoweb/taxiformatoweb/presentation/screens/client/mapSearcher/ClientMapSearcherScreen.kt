package com.formatoweb.taxiformatoweb.presentation.screens.client.mapSearcher

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController

@Composable
fun ClientMapSearcherScreen(navHostController: NavHostController) {
    Scaffold { paddingValues ->
        Text(
            modifier = Modifier.padding(paddingValues),
            text = "ClientMapSearcherScreen"
        )
    }
}
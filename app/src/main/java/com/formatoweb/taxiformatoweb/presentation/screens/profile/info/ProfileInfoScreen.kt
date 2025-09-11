package com.formatoweb.taxiformatoweb.presentation.screens.profile.info

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.formatoweb.taxiformatoweb.presentation.screens.profile.info.components.ProfileInfoContent

@Composable
fun ProfileInfoScreen(navHostController: NavHostController) {
    Scaffold (contentWindowInsets = WindowInsets.navigationBars)
    { paddingValues ->
        ProfileInfoContent(navHostController = navHostController, paddingValues)
    }
}
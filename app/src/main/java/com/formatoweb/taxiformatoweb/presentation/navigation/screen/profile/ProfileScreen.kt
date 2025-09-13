package com.formatoweb.taxiformatoweb.presentation.navigation.screen.profile

import com.formatoweb.taxiformatoweb.domain.model.User

sealed class ProfileScreen(val route: String) {
    object ProfileInfo: ProfileScreen("/profile/info")
    object ProfileUpdate: ProfileScreen("/profile/update/{user}"){
        fun passUser(user: String) = "/profile/update/${user}"
    }
}
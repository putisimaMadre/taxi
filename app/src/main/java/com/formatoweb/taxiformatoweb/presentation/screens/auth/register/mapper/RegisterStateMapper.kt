package com.formatoweb.taxiformatoweb.presentation.screens.auth.register.mapper

import com.formatoweb.taxiformatoweb.domain.model.User
import com.formatoweb.taxiformatoweb.presentation.screens.auth.register.RegisterState

fun RegisterState.toUser(): User {
    return User(
        name = name,
        lastname = lastName,
        email = email,
        phone = phone,
        password = password
    )
}
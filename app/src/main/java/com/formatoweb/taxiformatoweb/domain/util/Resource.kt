package com.formatoweb.taxiformatoweb.domain.util

import android.os.Message

sealed class Resource<out T> {
    object Loading: Resource<Nothing>()
    data class Success<out T>(val data: T): Resource<T>()
    data class Failure<out T>(val message: String): Resource<T>()
}
package com.example.nexus.ui.screens.home

sealed class HomeState<out T> {

    object Loading : HomeState<Nothing>()
    data class Success<T>(val items: List<T>) : HomeState<T>()
    data class Error(val message: String) : HomeState<Nothing>()

}
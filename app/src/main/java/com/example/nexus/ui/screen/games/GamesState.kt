package com.example.nexus.ui.screen.games

sealed class GamesState<out T> {

    object Loading : GamesState<Nothing>()
    data class Success<T>(val items: List<T>) : GamesState<T>()
    data class Error(val message: String) : GamesState<Nothing>()

}
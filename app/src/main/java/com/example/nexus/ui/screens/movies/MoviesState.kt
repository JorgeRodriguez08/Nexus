package com.example.nexus.ui.screens.movies

sealed class MoviesState<out Movie> {

    object Loading : MoviesState<Nothing>()
    data class Success<Movie>(val items: List<Movie>) : MoviesState<Movie>()
    data class Error(val message: String) : MoviesState<Nothing>()
}

package com.example.nexus.ui.screen.movieDetail

sealed class MovieState<out Movie> {
    object Loading : MovieState<Nothing>()
    data class Success<Movie>(val item: Movie) : MovieState<Movie>()
    data class Error(val message: String) : MovieState<Nothing>()
}
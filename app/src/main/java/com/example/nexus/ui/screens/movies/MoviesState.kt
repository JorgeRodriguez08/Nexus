package com.example.nexus.ui.screens.movies

import com.example.nexus.domain.model.Movie

sealed class MoviesState {

    object Loading : MoviesState()
    data class Success(val results: List<Movie>) : MoviesState()
    data class Error(val message: String) : MoviesState()

}

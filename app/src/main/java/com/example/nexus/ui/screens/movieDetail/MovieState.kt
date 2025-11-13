package com.example.nexus.ui.screens.movieDetail

import com.example.nexus.domain.model.Movie

sealed class MovieState {
    object Loading : MovieState()
    data class Success(val movies: List<Movie>) : MovieState()
    data class Error(val message: String) : MovieState()
}
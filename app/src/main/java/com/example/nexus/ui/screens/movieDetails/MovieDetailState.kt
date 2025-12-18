package com.example.nexus.ui.screens.movieDetails

import com.example.nexus.domain.model.MovieDetails

sealed class MovieDetailState {
    object Loading : MovieDetailState()
    data class Success(val movieDetails: MovieDetails) : MovieDetailState()
    data class Error(val message: String) : MovieDetailState()
}
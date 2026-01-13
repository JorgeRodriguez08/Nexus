package com.example.nexus.ui.screens.movieDetails

import com.example.nexus.domain.model.MovieDetails

sealed class MovieDetailsState {
    object Loading : MovieDetailsState()
    data class Success(val movieDetails: MovieDetails) : MovieDetailsState()
    data class Error(val message: String) : MovieDetailsState()
}
package com.example.nexus.ui.screens.movieDetail

import com.example.nexus.domain.models.MovieDetails

sealed class MovieDetailsState {
    object Loading : MovieDetailsState()
    data class Success(val movieDetails: MovieDetails) : MovieDetailsState()
    data class Error(val message: String) : MovieDetailsState()
}
package com.example.nexus.ui.screens.movieDetail

import com.example.nexus.domain.model.MovieDetails

sealed class MovieDetailState {
    object Loading : MovieDetailState()
    data class Success(val movieDetail: MovieDetails) : MovieDetailState()
    data class Error(val message: String) : MovieDetailState()
}
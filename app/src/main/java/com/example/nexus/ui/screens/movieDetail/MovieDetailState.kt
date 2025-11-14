package com.example.nexus.ui.screens.movieDetail

import com.example.nexus.domain.model.MovieDetail

sealed class MovieDetailState {
    object Loading : MovieDetailState()
    data class Success(val movieDetail: MovieDetail) : MovieDetailState()
    data class Error(val message: String) : MovieDetailState()
}
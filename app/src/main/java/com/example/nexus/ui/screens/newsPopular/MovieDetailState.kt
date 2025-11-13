package com.example.nexus.ui.screens.newsPopular

import com.example.nexus.domain.model.MovieDetail

sealed class MovieDetailState {

    object Loading : MovieDetailState()
    data class Success(val data: MovieDetail) : MovieDetailState()
    data class Error(val message: String) : MovieDetailState()

}
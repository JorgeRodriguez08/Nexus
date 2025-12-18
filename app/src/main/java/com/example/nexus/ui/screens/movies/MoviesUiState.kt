package com.example.nexus.ui.screens.movies

data class MoviesUiState(
    val moviesMap: Map<MovieCategory, MoviesState> = emptyMap()
)
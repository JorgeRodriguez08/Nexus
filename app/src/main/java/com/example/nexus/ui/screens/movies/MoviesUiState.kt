package com.example.nexus.ui.screens.movies

import com.example.nexus.domain.model.Movie

data class MoviesUiState(
    val moviesUiState: Map<MoviesCategory, MoviesState<Movie>> = emptyMap()
)
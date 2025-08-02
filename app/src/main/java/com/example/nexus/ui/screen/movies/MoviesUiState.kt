package com.example.nexus.ui.screen.movies

import com.example.nexus.domain.model.Movie

data class MoviesUiState(
    val moviesUiState: Map<MoviesCategory, MoviesState<Movie>> = emptyMap()
)
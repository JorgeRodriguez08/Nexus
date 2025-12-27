package com.example.nexus.ui.screens.movies

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier

@Composable
fun MoviesScreen(
    moviesViewModel: MoviesViewModel,
    onMovieClick: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    val featuredMovieState = moviesViewModel.featuredMoviesState.collectAsState().value
    val moviesUiState = moviesViewModel.moviesUiState.collectAsState().value

    MoviesLayout(
        featuredMovieState = featuredMovieState,
        moviesUiState = moviesUiState,
        categories = MoviesCategories.moviesCategories,
        onMovieClick = onMovieClick,
        modifier = modifier
    )
}
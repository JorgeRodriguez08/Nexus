package com.example.nexus.ui.screens.movies

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import com.example.nexus.ui.screens.movies.layout.MoviesContentLayout

@Composable
fun MoviesScreen(
    moviesViewModel: MoviesViewModel,
    onMovieClick: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    val featuredMoviesState = moviesViewModel.featuredMoviesState.collectAsState()
    val uiState = moviesViewModel.uiState.collectAsState()
    val moviesUiState = uiState.value.moviesUiState

    LaunchedEffect(Unit) {
        moviesViewModel.loadFeaturedMovies()
        moviesViewModel.loadMoviesContent()
    }

    MoviesContentLayout(
        featuredState = featuredMoviesState.value,
        moviesUiState = moviesUiState,
        categories = moviesViewModel.moviesCategories,
        onMovieClick = onMovieClick,
        modifier = modifier
    )
}
package com.example.nexus.ui.screen.movies

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import com.example.nexus.ui.screen.movies.layout.MoviesContentLayout

@Composable
fun MoviesScreen(
    moviesViewModel: MoviesViewModel,
    modifier: Modifier = Modifier
) {
    val featuredMoviesState = moviesViewModel.featuredMoviesState.collectAsState()
    val uiState = moviesViewModel.uiState.collectAsState()
    val moviesUiState = uiState.value.moviesUiState

    MoviesContentLayout(
        featuredState = featuredMoviesState.value,
        moviesUiState = moviesUiState,
        categories = moviesViewModel.moviesCategories,
        modifier = modifier
    )
}
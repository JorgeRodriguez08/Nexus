package com.example.nexus.ui.screens.games

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier

@Composable
fun GamesScreen(
    gamesViewModel: GamesViewModel,
    onMovieClick: (Int) -> Unit,
    onSerieClick: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    val featuredMovieState = gamesViewModel.featuredMoviesState.collectAsState().value
    val gamesUiState = gamesViewModel.gamesUiState.collectAsState().value

    LaunchedEffect(Unit) {
        gamesViewModel.loadFeaturedMovies()
        gamesViewModel.loadGamesContent()
    }

    GamesLayout(
        featuredMovieState = featuredMovieState,
        gamesUiState = gamesUiState,
        onMovieClick = onMovieClick,
        onSerieClick = onSerieClick,
        modifier = modifier
    )
}
package com.example.nexus.ui.screens.games

import androidx.compose.runtime.Composable
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
    val gamesState = gamesViewModel.gamesState.collectAsState().value
    val gamesTop10State = gamesViewModel.gamesTop10State.collectAsState().value

    GamesLayout(
        featuredMovieState = featuredMovieState,
        gamesUiState = gamesUiState,
        gamesState = gamesState,
        gamesTop10State = gamesTop10State,
        categories = GamesCategories.gamesCategories,
        onMovieClick = onMovieClick,
        onSerieClick = onSerieClick,
        modifier = modifier
    )
}
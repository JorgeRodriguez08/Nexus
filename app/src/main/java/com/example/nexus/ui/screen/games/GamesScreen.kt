package com.example.nexus.ui.screen.games

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import com.example.nexus.ui.screen.games.layout.GamesContentLayout

@Composable
fun GamesScreen(
    gamesViewModel: GamesViewModel,
    onMovieClick: (Int) -> Unit,
    onSeriesClick: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    val gamesUiState = gamesViewModel.gamesUiState.collectAsState().value
    val featuredState = gamesViewModel.featuredState.collectAsState().value
    LaunchedEffect(Unit) {
        gamesViewModel.loadFeaturedMovies()
        gamesViewModel.loadGamesContent()
    }

    GamesContentLayout(
        rows = gamesUiState.rows,
        moviesMap = gamesUiState.moviesMap,
        seriesMap = gamesUiState.seriesMap,
        onMovieClick = onMovieClick,
        onSeriesClick = onSeriesClick,
        featuredState = featuredState,
        modifier = modifier
    )


}
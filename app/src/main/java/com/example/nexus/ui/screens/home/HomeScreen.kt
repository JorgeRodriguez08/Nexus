package com.example.nexus.ui.screens.home

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier

@Composable
fun HomeScreen(
    homeViewModel: HomeViewModel,
    onMovieClick: (Int) -> Unit,
    onSerieClick: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    val featuredMovieState = homeViewModel.featuredMoviesState.collectAsState().value
    val gamesState = homeViewModel.gamesState.collectAsState().value
    val gamesTop10State = homeViewModel.gamesTop10State.collectAsState().value
    val homeUiState = homeViewModel.homeUiState.collectAsState().value

    HomeLayout(
        featuredMovieState = featuredMovieState,
        gamesState = gamesState,
        gamesTop10State = gamesTop10State,
        homeUiState = homeUiState,
        categories = HomeCategories.homeCategories,
        onMovieClick = onMovieClick,
        onSerieClick = onSerieClick,
        modifier = modifier
    )
}
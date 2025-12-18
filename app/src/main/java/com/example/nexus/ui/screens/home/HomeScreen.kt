package com.example.nexus.ui.screens.home

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
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
    val homeUiState = homeViewModel.homeUiState.collectAsState().value

    LaunchedEffect(Unit) {
        homeViewModel.loadFeaturedMovies()
        homeViewModel.loadHomeContent()
    }

    HomeLayout(
        featuredMovieState = featuredMovieState,
        homeUiState = homeUiState,
        onMovieClick = onMovieClick,
        onSerieClick = onSerieClick,
        modifier = modifier
    )
}
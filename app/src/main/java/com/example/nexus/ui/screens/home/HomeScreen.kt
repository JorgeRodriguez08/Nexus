package com.example.nexus.ui.screens.home

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import com.example.nexus.ui.screens.home.layout.HomeContentLayout

@Composable
fun HomeScreen(
    homeViewModel: HomeViewModel,
    onMovieClick: (Int) -> Unit,
    onSeriesClick: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    val featuredState = homeViewModel.featuredState.collectAsState()
    val homeUiState = homeViewModel.homeUiState.collectAsState().value

    LaunchedEffect(Unit) {
        homeViewModel.loadFeaturedMovies()
        homeViewModel.loadHomeContent()
    }

    HomeContentLayout(
        featuredState = featuredState.value,
        rows = homeUiState.rows,
        moviesMap = homeUiState.moviesMap,
        seriesMap = homeUiState.seriesMap,
        onMovieClick = onMovieClick,
        onSeriesClick = onSeriesClick,
        modifier = modifier
    )

}

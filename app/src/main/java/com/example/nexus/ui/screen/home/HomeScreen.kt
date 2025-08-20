package com.example.nexus.ui.screen.home

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import com.example.nexus.ui.screen.home.layout.HomeContentLayout

@Composable
fun HomeScreen(
    homeViewModel: HomeViewModel,
    modifier: Modifier = Modifier
) {
    val homeUiState = homeViewModel.homeUiState.collectAsState().value

    LaunchedEffect(Unit) {
        homeViewModel.loadHomeContent()
    }

    HomeContentLayout(
        rows = homeUiState.rows,
        moviesMap = homeUiState.moviesMap,
        seriesMap = homeUiState.seriesMap,
        modifier = modifier
    )

}

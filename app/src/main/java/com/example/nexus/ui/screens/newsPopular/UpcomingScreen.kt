package com.example.nexus.ui.screens.newsPopular

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import com.example.nexus.ui.screens.movies.MoviesState

@Composable
fun UpcomingScreen(
    upcomingViewModel: UpcomingViewModel,
    modifier: Modifier = Modifier
) {
    val moviesUiState = upcomingViewModel.moviesUiState.collectAsState().value

    LaunchedEffect(Unit) {
        upcomingViewModel.loadMoviesUpcoming()
    }

    when (moviesUiState) {
        is MoviesState.Loading -> { NewsMovieLayoutShimmer() }
        is MoviesState.Success -> { NewsMovieLayout(movies = moviesUiState.results) }
        is MoviesState.Error -> { NewsMovieLayoutShimmer() }
    }
}
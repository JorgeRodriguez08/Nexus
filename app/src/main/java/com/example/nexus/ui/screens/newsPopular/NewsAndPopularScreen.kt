package com.example.nexus.ui.screens.newsPopular

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import com.example.nexus.ui.screens.movies.MoviesState

@Composable
fun NewsAndPopularScreen(
    selectedFilter: FilterType,
    newsAndPopularViewModel: NewsAndPopularViewModel,
    modifier: Modifier = Modifier
) {
    LaunchedEffect(Unit) {
        newsAndPopularViewModel.setFilter(selectedFilter)
    }

    val moviesUiState = newsAndPopularViewModel.moviesUiState.collectAsState().value
    val moviesDetailStates = newsAndPopularViewModel.moviesDetailStates.collectAsState().value

    when (moviesUiState) {
        is MoviesState.Loading -> NewsMovieLayoutShimmer()
        is MoviesState.Success -> NewsMovieLayout(
            movies = moviesUiState.results,
            moviesDetailStates = moviesDetailStates
        )
        is MoviesState.Error -> NewsMovieLayoutShimmer()
    }
}
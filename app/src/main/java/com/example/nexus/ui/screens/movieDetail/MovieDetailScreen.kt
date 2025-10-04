package com.example.nexus.ui.screens.movieDetail

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier

@Composable
fun MovieDetailScreen(
    movieDetailViewModel: MovieDetailViewModel,
    movieId: Int,
    modifier: Modifier = Modifier
) {
    LaunchedEffect(movieId) {
        movieDetailViewModel.loadMovieDetail(movieId = movieId)
    }

    val movieDetailState = movieDetailViewModel.movieDetailState.collectAsState().value
    MovieDetailLayout(
        movieDetailState = movieDetailState,
        movieDetailViewModel = movieDetailViewModel,
        modifier = modifier
    )
}
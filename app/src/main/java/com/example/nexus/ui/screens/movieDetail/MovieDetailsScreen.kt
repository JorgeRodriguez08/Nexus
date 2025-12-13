package com.example.nexus.ui.screens.movieDetail

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier

@Composable
fun MovieDetailsScreen(
    movieDetailsViewModel: MovieDetailsViewModel,
    movieId: Int,
    modifier: Modifier = Modifier
) {
    LaunchedEffect(movieId) {
        movieDetailsViewModel.loadMovieDetail(movieId = movieId)
    }

    val movieDetailState = movieDetailsViewModel.movieDetailState.collectAsState().value
    MovieDetailLayout(
        movieDetailState = movieDetailState,
        modifier = modifier
    )
}
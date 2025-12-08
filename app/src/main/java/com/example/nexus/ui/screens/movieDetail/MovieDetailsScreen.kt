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
    val movieDetailsState = movieDetailsViewModel.movieDetailsState.collectAsState().value

    LaunchedEffect(movieId) {
        movieDetailsViewModel.loadMovieDetails(movieId)
    }

    MovieDetailsLayout(
        movieDetailsState = movieDetailsState,
        modifier = modifier
    )
}
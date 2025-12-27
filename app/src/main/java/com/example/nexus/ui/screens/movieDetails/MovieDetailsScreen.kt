package com.example.nexus.ui.screens.movieDetails

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
    movieDetailsViewModel.loadMovieDetails(movieId)
    val movieDetailsState = movieDetailsViewModel.movieDetailState.collectAsState().value

    LaunchedEffect(movieId) {
        movieDetailsViewModel.loadMovieDetails(movieId)
    }

    MovieDetailsLayout(
        movieDetailState = movieDetailsState,
        modifier = modifier
    )
}
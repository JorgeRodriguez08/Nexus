package com.example.nexus.ui.screen.movieDetail

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
    LaunchedEffect(Unit) {
        movieDetailViewModel.loadMovieDetail(movieId = movieId)
    }

    val movieDetailState = movieDetailViewModel.movieDetailState.collectAsState().value
    MovieDetailLayout(movieDetailState, modifier = modifier)
}
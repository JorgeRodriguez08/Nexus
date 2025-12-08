package com.example.nexus.ui.screens.movieDetail

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun MovieDetailsLayout(
    movieDetailsState: MovieDetailsState,
    modifier: Modifier = Modifier
) {
    when (movieDetailsState) {
        is MovieDetailsState.Loading -> { }
        is MovieDetailsState.Success -> {
            MovieDetailCard(
                movieDetails = movieDetailsState.movieDetails,
                modifier = modifier
            )
        }
        is MovieDetailsState.Error -> { }
    }
}
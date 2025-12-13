package com.example.nexus.ui.screens.movieDetail

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun MovieDetailLayout(
    movieDetailState: MovieDetailState,
    modifier: Modifier = Modifier
) {
    when (movieDetailState) {
        is MovieDetailState.Loading -> {
            MovieDetailCardShimmer()
        }
        is MovieDetailState.Success -> {
            MovieDetailCard(
                movieDetail = movieDetailState.movieDetail,
                modifier = modifier
            )
        }
        is MovieDetailState.Error -> {
            MovieDetailCardShimmer()
        }
    }
}
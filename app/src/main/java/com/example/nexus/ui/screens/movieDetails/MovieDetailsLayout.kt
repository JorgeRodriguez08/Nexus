package com.example.nexus.ui.screens.movieDetails

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.nexus.ui.components.card.MovieDetailsCard

@Composable
fun MovieDetailsLayout(
    movieDetailState: MovieDetailState,
    modifier: Modifier = Modifier
) {
    when (movieDetailState) {
        is MovieDetailState.Loading -> { }
        is MovieDetailState.Success -> {
            MovieDetailsCard(
                movieDetails = movieDetailState.movieDetails,
                modifier = modifier
            )
        }
        is MovieDetailState.Error -> { }
    }
}
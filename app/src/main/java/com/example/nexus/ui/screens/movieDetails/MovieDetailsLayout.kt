package com.example.nexus.ui.screens.movieDetails

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.nexus.ui.components.card.movie.MovieDetailsCard

@Composable
fun MovieDetailsLayout(
    movieDetailsState: MovieDetailsState,
    modifier: Modifier = Modifier
) {
    when (movieDetailsState) {
        is MovieDetailsState.Loading -> { }
        is MovieDetailsState.Success -> {
            MovieDetailsCard(
                movieDetails = movieDetailsState.movieDetails,
                modifier = modifier
            )
        }
        is MovieDetailsState.Error -> { }
    }
}
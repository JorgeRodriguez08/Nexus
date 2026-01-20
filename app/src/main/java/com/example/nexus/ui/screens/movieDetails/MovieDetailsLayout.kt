package com.example.nexus.ui.screens.movieDetails

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.nexus.ui.components.card.movie.MovieDetailsCard
import com.example.nexus.ui.shimmer.card.movie.MovieDetailsCardShimmer

@Composable
fun MovieDetailsLayout(
    movieDetailsState: MovieDetailsState,
    modifier: Modifier = Modifier
) {
    when (movieDetailsState) {
        is MovieDetailsState.Loading -> {
            MovieDetailsCardShimmer()
        }
        is MovieDetailsState.Success -> {
            MovieDetailsCard(
                movieDetails = movieDetailsState.movieDetails,
                modifier = modifier
            )
        }
        is MovieDetailsState.Error -> {
            MovieDetailsCardShimmer()
        }
    }
}
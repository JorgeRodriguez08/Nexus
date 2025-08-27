package com.example.nexus.ui.screen.movieDetail

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.nexus.domain.model.Movie

@Composable
fun MovieDetailLayout(
    movieState: MovieState<Movie>,
    modifier: Modifier = Modifier
) {
    when (movieState) {
        is MovieState.Loading -> { MovieDetailCardShimmer() }
        is MovieState.Success -> { MovieDetailCard(movie = movieState.item) }
        is MovieState.Error -> { MovieDetailCardShimmer() }
    }
}
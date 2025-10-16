package com.example.nexus.ui.screens.movieDetail

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun MovieDetailLayout(
    movieDetailState: MovieDetailState,
    movieDetailViewModel: MovieDetailViewModel,
    onFullClick: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    when (movieDetailState) {
        is MovieDetailState.Loading -> {
            MovieDetailCardShimmer()
        }
        is MovieDetailState.Success -> {
            MovieDetailCard(
                movie = movieDetailState.movie,
                video = movieDetailState.video,
                movieDetailViewModel = movieDetailViewModel,
                onFullClick = onFullClick,
                modifier = modifier
            )
        }
        is MovieDetailState.Error -> {
            MovieDetailCardShimmer()
        }
    }
}
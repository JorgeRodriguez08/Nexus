package com.example.nexus.ui.screens.movieDetail

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.nexus.domain.model.Movie
import com.example.nexus.domain.model.Video

@Composable
fun MovieDetailLayout(
    movieDetailState: MovieDetailState,
    movieDetailViewModel: MovieDetailViewModel,
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
                modifier = modifier
            )
        }
        is MovieDetailState.Error -> {
            MovieDetailCardShimmer()
        }
    }
}
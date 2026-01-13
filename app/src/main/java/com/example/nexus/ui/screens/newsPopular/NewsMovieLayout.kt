package com.example.nexus.ui.screens.newsPopular

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.nexus.domain.model.Movie
import com.example.nexus.ui.screens.movieDetails.MovieDetailsState
import com.example.nexus.ui.theme.Dimens

@Composable
fun NewsMovieLayout(
    movies: List<Movie>,
    moviesDetailsStates: Map<Int, MovieDetailsState>,
    onMovieClick: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    val filterMovies = movies.filter { movie ->
        val filterState = moviesDetailsStates[movie.id]
        when (filterState) {
            is MovieDetailsState.Loading -> true
            is MovieDetailsState.Success -> {
                filterState.movieDetails.logo != null
            }
            else -> false
        }
    }

    LazyColumn(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(Dimens.Padding.extraExtraLarge),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        items(filterMovies, key = { it.id }) { movie ->
            val movieDetailsState = moviesDetailsStates[movie.id]
            when (movieDetailsState) {
                null, is MovieDetailsState.Loading -> {  }
                is MovieDetailsState.Success -> {
                    NewsMovieCard(
                        movieDetails = movieDetailsState.movieDetails,
                        onMovieClick = onMovieClick
                    )
                }
                is MovieDetailsState.Error -> {  }
            }
        }
    }
}
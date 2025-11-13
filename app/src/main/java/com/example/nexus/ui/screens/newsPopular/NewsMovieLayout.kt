package com.example.nexus.ui.screens.newsPopular

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.nexus.domain.model.Movie

@Composable
fun NewsMovieLayout(
    movies: List<Movie>,
    moviesDetailStates: Map<Int, MovieDetailState>,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        items(movies) { movie ->
            val movieDetailState = moviesDetailStates[movie.id]

            when (movieDetailState) {
                null, is MovieDetailState.Loading -> NewsMovieCardShimmer()
                is MovieDetailState.Success -> {
                    NewsMovieCard(movieDetailState.data)
                }
                is MovieDetailState.Error -> {  }
            }
        }
    }
}
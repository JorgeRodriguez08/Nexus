package com.example.nexus.ui.screens.search

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.nexus.domain.model.Movie
import com.example.nexus.ui.components.lazyrow.movies.MoviesLazyRow
import com.example.nexus.ui.screens.movies.MoviesState

@Composable
fun SearchResultsLayout(
    searchState: MoviesState,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(top = 16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        items(2) { index ->

            when (searchState) {
                is MoviesState.Loading -> {}
                is MoviesState.Success -> {
                    MoviesLazyRow(
                        title = "Principales resultados",
                        movies = searchState.results,
                        onMovieClick = { }
                ) }
                is MoviesState.Error -> {}
            }
        }
    }
}

val movies = List(10) {
    Movie(
        id = 1,
        title = "Movie",
        overview = "Overview of movie",
        posterUrl = "",
        backdropUrl = "",
        voteAverage = 1.1,
        adult = true,
        releaseDate = "2024-01-01",
        runtime = 1
    )
}
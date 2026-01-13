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
import com.example.nexus.ui.components.lazyrow.series.SeriesLazyRow
import com.example.nexus.ui.screens.movies.MoviesState
import com.example.nexus.ui.screens.series.SeriesState

@Composable
fun SearchResultsLayout(
    searchMovieState: MoviesState,
    searchSerieState: SeriesState,
    moviesState: MoviesState,
    seriesState: SeriesState,
    onMovieClick: (Int) -> Unit,
    onSerieClick: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(top = 16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            when (searchMovieState) {
                is MoviesState.Loading -> {}
                is MoviesState.Success -> {
                    MoviesLazyRow(
                        title = "Principales resultados de películas",
                        movies = searchMovieState.results,
                        onMovieClick = onMovieClick
                    )
                }
                is MoviesState.Error -> {}
            }

            when (searchSerieState) {
                is SeriesState.Loading -> {}
                is SeriesState.Success -> {
                    SeriesLazyRow(
                        title = "Principales resultados de series",
                        series = searchSerieState.results,
                        onSerieClick = onSerieClick
                    )
                }
                is SeriesState.Error -> {}
            }
        }

        item{
            when (moviesState) {
                is MoviesState.Loading -> {}
                is MoviesState.Success -> {
                    if (!moviesState.results.isEmpty()) {
                        MoviesLazyRow(
                            title = "Nuestra selección de hoy para ti",
                            movies = moviesState.results,
                            onMovieClick = onMovieClick
                        )
                    }
                }
                is MoviesState.Error -> {}
            }

            when (seriesState) {
                is SeriesState.Loading -> {}
                is SeriesState.Success -> {
                    if (!seriesState.results.isEmpty()) {
                        SeriesLazyRow(
                            title = "Creemos que estas te encantarán",
                            series = seriesState.results,
                            onSerieClick = onSerieClick
                        )
                    }
                }
                is SeriesState.Error -> {}
            }
        }
    }
}
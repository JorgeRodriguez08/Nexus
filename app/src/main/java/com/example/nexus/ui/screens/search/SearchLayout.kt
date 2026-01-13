package com.example.nexus.ui.screens.search

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.nexus.ui.screens.movies.MoviesState
import com.example.nexus.ui.screens.series.SeriesState

@Composable
fun SearchLayout(
    gamesState: MoviesState,
    moviesState: MoviesState,
    seriesState: SeriesState,
    onMovieClick: (Int) -> Unit,
    onSerieClick: (Int) -> Unit,
    modifier: Modifier = Modifier

) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 13.dp, top = 10.dp),
        verticalArrangement = Arrangement.spacedBy(13.dp),
        horizontalAlignment = Alignment.Start

    ) {
        item {
            when (gamesState) {
                is MoviesState.Loading -> {}
                is MoviesState.Success -> {
                    GamesSection(
                        games = gamesState.results,
                        onMovieClick = onMovieClick
                    )
                }
                is MoviesState.Error -> {}
            }
        }

        item {
            when (moviesState) {
                is MoviesState.Loading -> {}
                is MoviesState.Success -> {
                    MoviesSection(
                        movies = moviesState.results,
                        onMovieClick = onMovieClick
                    )
                }
                is MoviesState.Error -> {}
            }
        }

        item {
            when (seriesState) {
                is SeriesState.Loading -> {}
                is SeriesState.Success -> {
                    SeriesSection(
                        series = seriesState.results,
                        onSerieClick = onSerieClick
                    )
                }
                is SeriesState.Error -> {}
            }
        }
    }
}
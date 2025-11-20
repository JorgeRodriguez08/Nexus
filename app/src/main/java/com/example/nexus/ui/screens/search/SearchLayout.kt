package com.example.nexus.ui.screens.search

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.nexus.ui.screens.movies.MoviesState

@Composable
fun SearchLayout(
    gamesState: MoviesState,
    moviesState: MoviesState,
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
                is MoviesState.Success -> GamesSection(games = gamesState.results)
                is MoviesState.Error -> {}
            }
        }

        item {
            when (moviesState) {
                is MoviesState.Loading -> {}
                is MoviesState.Success -> MoviesAndSeriesSection(movies = moviesState.results)
                is MoviesState.Error -> {}
            }
        }
    }
}

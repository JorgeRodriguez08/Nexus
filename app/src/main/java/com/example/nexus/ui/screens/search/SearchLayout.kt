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
import com.example.nexus.ui.shimmer.lazyrow.games.GamesSectionShimmer
import com.example.nexus.ui.shimmer.lazyrow.movies.MoviesSectionShimmer
import com.example.nexus.ui.shimmer.lazyrow.series.SeriesSectionShimmer
import com.example.nexus.ui.theme.Dimens

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
            .padding(
                start = 13.dp,
                top = 10.dp,
                bottom = Dimens.Padding.sectionExtraLarge
            ),
        verticalArrangement = Arrangement.spacedBy(13.dp),
        horizontalAlignment = Alignment.Start

    ) {
        item {
            when (gamesState) {
                is MoviesState.Loading -> {
                    GamesSectionShimmer()
                }
                is MoviesState.Success -> {
                    GamesSection(
                        games = gamesState.results,
                        onMovieClick = onMovieClick
                    )
                }
                is MoviesState.Error -> {
                    GamesSectionShimmer()
                }
            }
        }

        item {
            when (moviesState) {
                is MoviesState.Loading -> {
                    MoviesSectionShimmer()
                }
                is MoviesState.Success -> {
                    MoviesSection(
                        movies = moviesState.results,
                        onMovieClick = onMovieClick
                    )
                }
                is MoviesState.Error -> {
                    MoviesSectionShimmer()
                }
            }
        }

        item {
            when (seriesState) {
                is SeriesState.Loading -> {
                    SeriesSectionShimmer()
                }
                is SeriesState.Success -> {
                    SeriesSection(
                        series = seriesState.results,
                        onSerieClick = onSerieClick
                    )
                }
                is SeriesState.Error -> {
                    SeriesSectionShimmer()
                }
            }
        }
    }
}
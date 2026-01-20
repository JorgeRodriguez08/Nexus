package com.example.nexus.ui.screens.search

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.nexus.ui.components.lazyrow.movies.MoviesLazyRow
import com.example.nexus.ui.components.lazyrow.series.SeriesLazyRow
import com.example.nexus.ui.screens.movies.MoviesState
import com.example.nexus.ui.screens.series.SeriesState
import com.example.nexus.ui.shimmer.lazyrow.movies.MoviesLazyRowShimmer
import com.example.nexus.ui.shimmer.lazyrow.series.SeriesLazyRowShimmer
import com.example.nexus.ui.theme.Dimens
import com.example.nexus.ui.theme.Strings

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
        modifier = Modifier
            .fillMaxSize()
            .padding(
                bottom = Dimens.Padding.sectionExtraLarge
            ),
        verticalArrangement = Arrangement.spacedBy(13.dp),
        horizontalAlignment = Alignment.Start
    ) {
        item {
            when (searchMovieState) {
                is MoviesState.Loading -> {
                    MoviesLazyRowShimmer(
                        title = Strings.Search.searchMoviesResults
                    )
                }
                is MoviesState.Success -> {
                    if (!searchMovieState.results.isEmpty()) {
                        MoviesLazyRow(
                            title = Strings.Search.searchMoviesResults,
                            movies = searchMovieState.results,
                            onMovieClick = onMovieClick
                        )
                    }
                }
                is MoviesState.Error -> {
                    MoviesLazyRowShimmer(
                        title = Strings.Search.searchMoviesResults
                    )
                }
            }

            when (searchSerieState) {
                is SeriesState.Loading -> {
                    SeriesLazyRowShimmer(
                        title = Strings.Search.searchSeriesResults
                    )
                }
                is SeriesState.Success -> {
                    if (!searchSerieState.results.isEmpty()) {
                        SeriesLazyRow(
                            title = Strings.Search.searchSeriesResults,
                            series = searchSerieState.results,
                            onSerieClick = onSerieClick
                        )
                    }
                }
                is SeriesState.Error -> {
                    SeriesLazyRowShimmer(
                        title = Strings.Search.searchSeriesResults
                    )
                }
            }
        }

        item{
            when (moviesState) {
                is MoviesState.Loading -> {
                    MoviesLazyRowShimmer(
                        title = "Nuestra selección de hoy para ti"
                    )
                }
                is MoviesState.Success -> {
                    if (!moviesState.results.isEmpty()) {
                        MoviesLazyRow(
                            title = "Nuestra selección de hoy para ti",
                            movies = moviesState.results,
                            onMovieClick = onMovieClick
                        )
                    }
                }
                is MoviesState.Error -> {
                    MoviesLazyRowShimmer(
                        title = "Nuestra selección de hoy para ti"
                    )
                }
            }

            when (seriesState) {
                is SeriesState.Loading -> {
                    SeriesLazyRowShimmer(
                        title = "Creemos que estas te encantarán"
                    )
                }
                is SeriesState.Success -> {
                    if (!seriesState.results.isEmpty()) {
                        SeriesLazyRow(
                            title = "Creemos que estas te encantarán",
                            series = seriesState.results,
                            onSerieClick = onSerieClick
                        )
                    }
                }
                is SeriesState.Error -> {
                    SeriesLazyRowShimmer(
                        title = "Creemos que estas te encantarán"
                    )
                }
            }
        }
    }
}
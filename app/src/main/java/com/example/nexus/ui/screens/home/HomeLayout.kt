package com.example.nexus.ui.screens.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.nexus.ui.components.card.MovieCardLarge
import com.example.nexus.ui.components.lazyrow.MoviesLazyRow
import com.example.nexus.ui.components.lazyrow.SeriesLazyRow
import com.example.nexus.ui.screens.games.GamesMobileRecommended
import com.example.nexus.ui.screens.games.GamesMobileTop10
import com.example.nexus.ui.screens.movies.MovieCategory
import com.example.nexus.ui.screens.movies.MoviesState
import com.example.nexus.ui.screens.series.SerieCategory
import com.example.nexus.ui.screens.series.SeriesState
import com.example.nexus.ui.theme.Dimens

@Composable
fun HomeLayout(
    featuredMovieState: MoviesState,
    homeUiState: HomeUiState,
    onMovieClick: (Int) -> Unit,
    onSerieClick: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(top = Dimens.Padding.huge),
        verticalArrangement = Arrangement.spacedBy(Dimens.Spacing.jumbo),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            when (featuredMovieState) {
                is MoviesState.Loading -> {  }
                is MoviesState.Success -> {
                    val featuredMovie = featuredMovieState.results.random()
                    MovieCardLarge(
                        movie = featuredMovie,
                        onMovieClick =  onMovieClick
                    )
                }
                is MoviesState.Error -> {  }
            }
        }

        item {
            when (featuredMovieState) {
                is MoviesState.Loading -> {  }
                is MoviesState.Success -> {
                    GamesMobileRecommended(
                        games = featuredMovieState.results
                    )
                }
                is MoviesState.Error -> { }
            }
        }

        item {
            when (featuredMovieState) {
                is MoviesState.Loading -> {  }
                is MoviesState.Success -> {
                    GamesMobileTop10(
                        games = featuredMovieState.results
                    )
                }
                is MoviesState.Error -> {  }
            }
        }

        val homeCategories = HomeCategories.homeCategories
        items(homeCategories) { category ->
            when (category) {
                is MovieCategory -> {
                    val moviesMap = homeUiState.moviesMap
                    val moviesState = moviesMap[category]
                    when (moviesState) {
                        null, is MoviesState.Loading -> {  }
                        is MoviesState.Success -> {
                            MoviesLazyRow(
                                title = category.title,
                                movies = moviesState.results,
                                onMovieClick = onMovieClick
                            )
                        }
                        is MoviesState.Error -> {  }
                    }
                }

                is SerieCategory -> {
                    val seriesMap = homeUiState.seriesMap
                    val seriesState = seriesMap[category]
                    when (seriesState) {
                        null, is SeriesState.Loading -> { }
                        is SeriesState.Success -> {
                            SeriesLazyRow(
                                title = category.title,
                                series = seriesState.results,
                                onSerieClick = onSerieClick
                            )
                        }
                        is SeriesState.Error -> {  }
                    }
                }
            }
        }
    }
}
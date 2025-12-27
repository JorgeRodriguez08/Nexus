package com.example.nexus.ui.screens.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.nexus.ui.components.card.movie.MovieCardLarge
import com.example.nexus.ui.components.lazyrow.games.GamesMobileRecommended
import com.example.nexus.ui.components.lazyrow.games.GamesMobileTop10
import com.example.nexus.ui.components.lazyrow.movies.MoviesLazyRow
import com.example.nexus.ui.components.lazyrow.movies.MoviesMediumLazyRow
import com.example.nexus.ui.components.lazyrow.movies.MoviesRegularLazyRow
import com.example.nexus.ui.components.lazyrow.movies.MoviesTop10LazyRow
import com.example.nexus.ui.components.lazyrow.series.SeriesLazyRow
import com.example.nexus.ui.components.lazyrow.series.SeriesMediumLazyRow
import com.example.nexus.ui.components.lazyrow.series.SeriesRegularLazyRow
import com.example.nexus.ui.components.lazyrow.series.SeriesTop10LazyRow
import com.example.nexus.ui.screens.movies.MovieCategory
import com.example.nexus.ui.screens.movies.MoviesState
import com.example.nexus.ui.screens.series.SerieCategory
import com.example.nexus.ui.screens.series.SeriesState
import com.example.nexus.ui.theme.Dimens

@Composable
fun HomeLayout(
    featuredMovieState: MoviesState,
    homeUiState: HomeUiState,
    categories: List<Any>,
    onMovieClick: (Int) -> Unit,
    onSerieClick: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(top = Dimens.Padding.sectionSmall),
        verticalArrangement = Arrangement.spacedBy(Dimens.Padding.extraExtraLarge),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            when (featuredMovieState) {
                is MoviesState.Loading -> {  }
                is MoviesState.Success -> {
                    val featuredMovie = featuredMovieState.results.first()
                    MovieCardLarge(
                        movie = featuredMovie,
                        onMovieClick = onMovieClick
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

        items(categories) { category ->
            when (category) {
                is MovieCategory -> {
                    val moviesMap = homeUiState.moviesMap
                    val moviesState = moviesMap[category]
                    when (moviesState) {
                        null, is MoviesState.Loading -> {  }
                        is MoviesState.Success -> {
                            when (category) {
                                MovieCategory.UpComing -> {
                                    MoviesMediumLazyRow(
                                        title = category.title,
                                        movies = moviesState.results,
                                        onMovieClick = onMovieClick
                                    )
                                }
                                MovieCategory.OnlyNexus -> {
                                    MoviesRegularLazyRow(
                                        title = category.title,
                                        movies = moviesState.results,
                                        onMovieClick = onMovieClick
                                    )
                                }
                                MovieCategory.Trending -> {
                                    MoviesTop10LazyRow(
                                        title = category.title,
                                        movies = moviesState.results,
                                        onMovieClick = onMovieClick
                                    )
                                }
                                MovieCategory.NowPlaying -> {
                                    MoviesMediumLazyRow(
                                        title = category.title,
                                        movies = moviesState.results,
                                        onMovieClick = onMovieClick
                                    )
                                }
                                else -> {
                                    MoviesLazyRow(
                                        title = category.title,
                                        movies = moviesState.results,
                                        onMovieClick = onMovieClick
                                    )
                                }
                            }
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
                            when (category) {
                                SerieCategory.OnTheAir -> {
                                    SeriesMediumLazyRow(
                                        title = category.title,
                                        series = seriesState.results,
                                        onSerieClick = onSerieClick
                                    )
                                }
                                SerieCategory.OnlyNexus -> {
                                    SeriesRegularLazyRow(
                                        title = category.title,
                                        series = seriesState.results,
                                        onSerieClick = onSerieClick
                                    )
                                }
                                SerieCategory.Trending -> {
                                    SeriesTop10LazyRow(
                                        title = category.title,
                                        series = seriesState.results,
                                        onSerieClick = onSerieClick,
                                    )
                                }
                                SerieCategory.AiringToday -> {
                                    SeriesMediumLazyRow(
                                        title = category.title,
                                        series = seriesState.results,
                                        onSerieClick = onSerieClick
                                    )
                                }
                                else -> {
                                    SeriesLazyRow(
                                        title = category.title,
                                        series = seriesState.results,
                                        onSerieClick = onSerieClick
                                    )
                                }
                            }
                        }
                        is SeriesState.Error -> {  }
                    }
                }
            }
        }
    }
}
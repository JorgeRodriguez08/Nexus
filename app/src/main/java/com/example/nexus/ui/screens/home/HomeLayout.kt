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
import com.example.nexus.ui.shimmer.card.movie.MovieCardLargeShimmer
import com.example.nexus.ui.shimmer.lazyrow.movies.MoviesLazyRowShimmer
import com.example.nexus.ui.shimmer.lazyrow.movies.MoviesMediumLazyRowShimmer
import com.example.nexus.ui.shimmer.lazyrow.movies.MoviesRegularLazyRowShimmer
import com.example.nexus.ui.shimmer.lazyrow.movies.MoviesTop10LazyRowShimmer
import com.example.nexus.ui.shimmer.lazyrow.series.SeriesLazyRowShimmer
import com.example.nexus.ui.shimmer.lazyrow.series.SeriesMediumLazyRowShimmer
import com.example.nexus.ui.shimmer.lazyrow.series.SeriesRegularLazyRowShimmer
import com.example.nexus.ui.shimmer.lazyrow.series.SeriesTop10LazyRowShimmer
import com.example.nexus.ui.screens.movies.MovieCategory
import com.example.nexus.ui.screens.movies.MoviesState
import com.example.nexus.ui.screens.series.SerieCategory
import com.example.nexus.ui.screens.series.SeriesState
import com.example.nexus.ui.shimmer.lazyrow.games.GamesMobileRecommendedShimmer
import com.example.nexus.ui.shimmer.lazyrow.games.GamesMobileTop10Shimmer
import com.example.nexus.ui.theme.Dimens

@Composable
fun HomeLayout(
    featuredMovieState: MoviesState,
    gamesState: MoviesState,
    gamesTop10State: MoviesState,
    homeUiState: HomeUiState,
    categories: List<Any>,
    onMovieClick: (Int) -> Unit,
    onSerieClick: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(
                top = Dimens.Padding.sectionSmall,
                bottom = Dimens.Padding.sectionExtraLarge
            ),
        verticalArrangement = Arrangement.spacedBy(Dimens.Padding.extraExtraLarge),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            when (featuredMovieState) {
                is MoviesState.Loading -> {
                    MovieCardLargeShimmer()
                }
                is MoviesState.Success -> {
                    val featuredMovie = featuredMovieState.results.first()
                    MovieCardLarge(
                        movie = featuredMovie,
                        onMovieClick = onMovieClick
                    )
                }
                is MoviesState.Error -> {
                    MovieCardLargeShimmer()
                }
            }
        }

        item {
            when (gamesState) {
                is MoviesState.Loading -> {
                    GamesMobileRecommendedShimmer()
                }
                is MoviesState.Success -> {
                    GamesMobileRecommended(
                        games = gamesState.results,
                        onMovieClick = onMovieClick
                    )
                }
                is MoviesState.Error -> {
                    GamesMobileRecommendedShimmer()
                }
            }
        }

        item {
            when (gamesTop10State) {
                is MoviesState.Loading -> {
                    GamesMobileTop10Shimmer()
                }
                is MoviesState.Success -> {
                    GamesMobileTop10(
                        games = gamesTop10State.results,
                        onMovieClick = onMovieClick
                    )
                }
                is MoviesState.Error -> {
                    GamesMobileTop10Shimmer()
                }
            }
        }

        items(categories) { category ->
            when (category) {
                is MovieCategory -> {
                    val moviesMap = homeUiState.moviesMap
                    val moviesState = moviesMap[category]
                    when (moviesState) {
                        null, is MoviesState.Loading, is MoviesState.Error -> {
                            when (category) {
                                is MovieCategory.Upcoming -> {
                                    MoviesMediumLazyRowShimmer(
                                        title = category.title
                                    )
                                }
                                is MovieCategory.OnlyNexus -> {
                                    MoviesRegularLazyRowShimmer(
                                        title = category.title
                                    )
                                }
                                is MovieCategory.Trending -> {
                                    MoviesTop10LazyRowShimmer(
                                        title = category.title
                                    )
                                }
                                is MovieCategory.NowPlaying -> {
                                    MoviesMediumLazyRowShimmer(
                                        title = category.title
                                    )
                                }
                                else -> {
                                    MoviesLazyRowShimmer(
                                        title = category.title
                                    )
                                }
                            }
                        }
                        is MoviesState.Success -> {
                            when (category) {
                                is MovieCategory.Upcoming -> {
                                    MoviesMediumLazyRow(
                                        title = category.title,
                                        movies = moviesState.results,
                                        onMovieClick = onMovieClick
                                    )
                                }
                                is MovieCategory.OnlyNexus -> {
                                    MoviesRegularLazyRow(
                                        title = category.title,
                                        movies = moviesState.results,
                                        onMovieClick = onMovieClick
                                    )
                                }
                                is MovieCategory.Trending -> {
                                    MoviesTop10LazyRow(
                                        title = category.title,
                                        movies = moviesState.results,
                                        onMovieClick = onMovieClick
                                    )
                                }
                                is MovieCategory.NowPlaying -> {
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
                    }
                }

                is SerieCategory -> {
                    val seriesMap = homeUiState.seriesMap
                    val seriesState = seriesMap[category]
                    when (seriesState) {
                        null, is SeriesState.Loading, is SeriesState.Error -> {
                            when (category) {
                                is SerieCategory.OnTheAir -> {
                                    SeriesMediumLazyRowShimmer(
                                        title = category.title
                                    )
                                }
                                is SerieCategory.OnlyNexus -> {
                                    SeriesRegularLazyRowShimmer(
                                        title = category.title
                                    )
                                }
                                is SerieCategory.Trending -> {
                                    SeriesTop10LazyRowShimmer(
                                        title = category.title
                                    )
                                }
                                is SerieCategory.AiringToday -> {
                                    SeriesMediumLazyRowShimmer(
                                        title = category.title
                                    )
                                }
                                else -> {
                                    SeriesLazyRowShimmer(
                                        title = category.title
                                    )
                                }
                            }
                        }
                        is SeriesState.Success -> {
                            when (category) {
                                is SerieCategory.OnTheAir -> {
                                    SeriesMediumLazyRow(
                                        title = category.title,
                                        series = seriesState.results,
                                        onSerieClick = onSerieClick
                                    )
                                }
                                is SerieCategory.OnlyNexus -> {
                                    SeriesRegularLazyRow(
                                        title = category.title,
                                        series = seriesState.results,
                                        onSerieClick = onSerieClick
                                    )
                                }
                                is SerieCategory.Trending -> {
                                    SeriesTop10LazyRow(
                                        title = category.title,
                                        series = seriesState.results,
                                        onSerieClick = onSerieClick,
                                    )
                                }
                                is SerieCategory.AiringToday -> {
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
                    }
                }
            }
        }
    }
}
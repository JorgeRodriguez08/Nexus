package com.example.nexus.ui.screens.movies

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.nexus.ui.components.card.movie.MovieCardLarge
import com.example.nexus.ui.components.lazyrow.movies.MoviesLazyRow
import com.example.nexus.ui.components.lazyrow.movies.MoviesMediumLazyRow
import com.example.nexus.ui.components.lazyrow.movies.MoviesRegularLazyRow
import com.example.nexus.ui.components.lazyrow.movies.MoviesTop10LazyRow
import com.example.nexus.ui.theme.Dimens

@Composable
fun MoviesLayout(
    featuredMovieState: MoviesState,
    moviesUiState: MoviesUiState,
    categories: List<MovieCategory>,
    onMovieClick: (Int) -> Unit,
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
                    val featuredMovie = featuredMovieState.results.get(2)
                    MovieCardLarge(
                        movie = featuredMovie,
                        onMovieClick = onMovieClick
                    )
                }
                is MoviesState.Error -> {  }
            }
        }

        items(categories) { category ->
            val moviesMap = moviesUiState.moviesMap
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
    }
}
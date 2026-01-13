package com.example.nexus.ui.screens.newsPopular

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import com.example.nexus.ui.components.filterbar.NewsFilter
import com.example.nexus.ui.screens.movies.MoviesState
import com.example.nexus.ui.screens.series.SeriesState

@Composable
fun NewsScreen(
    newsViewModel: NewsViewModel,
    selectedFilter: NewsFilter,
    onMovieClick: (Int) -> Unit,
    onSerieClick: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    val moviesState = newsViewModel.moviesState.collectAsState().value
    val moviesDetailsStates = newsViewModel.moviesDetailsStates.collectAsState().value
    val seriesState = newsViewModel.seriesState.collectAsState().value
    val seriesDetailsStates = newsViewModel.seriesDetailStates.collectAsState().value

    LaunchedEffect(selectedFilter) {
        newsViewModel.setFilter(selectedFilter)
    }

    when (selectedFilter) {
        is NewsFilter.Upcoming, NewsFilter.Cool, NewsFilter.MobileGames, NewsFilter.Top10Movies -> {
            when (moviesState) {
                is MoviesState.Loading -> {}
                is MoviesState.Success -> {
                    NewsMovieLayout(
                        movies = moviesState.results,
                        moviesDetailsStates = moviesDetailsStates,
                        onMovieClick = onMovieClick
                    )
                }
                is MoviesState.Error -> {}
            }
        }
        is NewsFilter.Top10Series -> {
            when (seriesState) {
                is SeriesState.Loading -> {}
                is SeriesState.Success -> {
                    NewsSerieLayout(
                        series = seriesState.results,
                        seriesDetailsStates = seriesDetailsStates,
                        onSerieClick = onSerieClick
                    )
                }
                is SeriesState.Error -> {}
            }
        }
    }
}
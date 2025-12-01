package com.example.nexus.ui.screens.home.layout

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.nexus.domain.model.Movie
import com.example.nexus.ui.components.lazyrow.MoviesLazyRow
import com.example.nexus.ui.components.lazyrow.SeriesLazyRow
import com.example.nexus.ui.components.shimmer.MoviesRowShimmer
import com.example.nexus.ui.components.shimmer.SeriesRowShimmer
import com.example.nexus.domain.model.Series
import com.example.nexus.ui.components.card.MovieCardLarge
import com.example.nexus.ui.components.shimmer.MoviesCardLargeShimmer
import com.example.nexus.ui.screens.games.GamesSection
import com.example.nexus.ui.screens.games.GamesTop10Section
import com.example.nexus.ui.screens.home.HomeRow
import com.example.nexus.ui.screens.home.HomeState
import com.example.nexus.ui.screens.movies.MoviesCategory
import com.example.nexus.ui.screens.movies.MoviesState
import com.example.nexus.ui.screens.series.SeriesCategory

@Composable
fun HomeContentLayout(
    featuredState: MoviesState,
    rows: List<HomeRow>,
    moviesMap: Map<MoviesCategory, HomeState<Movie>>,
    seriesMap: Map<SeriesCategory, HomeState<Series>>,
    onMovieClick: (Int) -> Unit,
    onSeriesClick: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(start = 13.dp, top = 16.dp),
        verticalArrangement = Arrangement.spacedBy(18.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            when (featuredState) {
                is MoviesState.Loading -> { MoviesCardLargeShimmer() }
                is MoviesState.Success -> {
                    val featured = featuredState.results.first()
                    MovieCardLarge(featured, onMovieClick =  onMovieClick)
                }
                is MoviesState.Error -> { MoviesCardLargeShimmer() }
            }
        }

        item {
            when (featuredState) {
                is MoviesState.Loading -> {  }
                is MoviesState.Success -> { GamesSection(games = featuredState.results) }
                is MoviesState.Error -> { }
            }
        }

        item {
            when (featuredState) {
                is MoviesState.Loading -> {  }
                is MoviesState.Success -> { GamesTop10Section(games = featuredState.results) }
                is MoviesState.Error -> { }
            }
        }

        items(rows) { row ->
            when (row) {
                is HomeRow.MoviesRow -> {
                    val homeState = moviesMap[row.category]
                    when (homeState) {
                        null, is HomeState.Loading -> MoviesRowShimmer(row.category.title)
                        is HomeState.Success -> MoviesLazyRow(row.category.title, movies = homeState.items, onMovieClick = onMovieClick)
                        is HomeState.Error -> MoviesRowShimmer(row.category.title)
                    }
                }

                is HomeRow.SeriesRow -> {
                    val homeState = seriesMap[row.category]
                    when (homeState) {
                        null, is HomeState.Loading -> SeriesRowShimmer(row.category.title)
                        is HomeState.Success -> SeriesLazyRow(row.category.title, seriesList = homeState.items, onSeriesClick = onSeriesClick)
                        is HomeState.Error -> SeriesRowShimmer(row.category.title)
                    }
                }
            }
        }
    }

}
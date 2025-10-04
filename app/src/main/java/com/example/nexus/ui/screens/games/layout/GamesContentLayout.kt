package com.example.nexus.ui.screens.games.layout

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
import com.example.nexus.domain.model.Series
import com.example.nexus.ui.components.card.MovieCardLarge
import com.example.nexus.ui.components.lazyrow.MoviesLazyRow
import com.example.nexus.ui.components.lazyrow.SeriesLazyRow
import com.example.nexus.ui.components.shimmer.MoviesCardLargeShimmer
import com.example.nexus.ui.components.shimmer.MoviesRowShimmer
import com.example.nexus.ui.components.shimmer.SeriesRowShimmer
import com.example.nexus.ui.screens.games.GamesRow
import com.example.nexus.ui.screens.games.GamesState
import com.example.nexus.ui.screens.movies.MoviesCategory
import com.example.nexus.ui.screens.movies.MoviesState
import com.example.nexus.ui.screens.series.SeriesCategory

@Composable
fun GamesContentLayout(

    rows: List<GamesRow>,
    moviesMap: Map<MoviesCategory, GamesState<Movie>>,
    seriesMap: Map<SeriesCategory, GamesState<Series>>,
    onMovieClick: (Int) -> Unit,
    onSeriesClick: (Int) -> Unit,
    featuredState: MoviesState<Movie>,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(top = 16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            when (featuredState) {
                is MoviesState.Loading -> { MoviesCardLargeShimmer() }
                is MoviesState.Success -> {
                    val featured = featuredState.items.first()
                    MovieCardLarge(featured, onMovieClick =  onMovieClick)
                }
                is MoviesState.Error -> { MoviesCardLargeShimmer() }
            }
        }

        items(rows) { row ->
            when (row) {
                is GamesRow.MoviesRow -> {
                    val gamesState = moviesMap[row.category]
                    when (gamesState) {
                        null, is GamesState.Loading -> MoviesRowShimmer(row.category.title)
                        is GamesState.Success -> MoviesLazyRow(row.category.title, movies = gamesState.items, onMovieClick = onMovieClick)
                        is GamesState.Error -> MoviesRowShimmer(row.category.title)
                    }
                }

                is GamesRow.SeriesRow -> {
                    val gamesState = seriesMap[row.category]
                    when (gamesState) {
                        null, is GamesState.Loading -> SeriesRowShimmer(row.category.title)
                        is GamesState.Success -> SeriesLazyRow(row.category.title, seriesList = gamesState.items, onSeriesClick = onSeriesClick)
                        is GamesState.Error -> SeriesRowShimmer(row.category.title)
                    }
                }
            }
        }
    }
}
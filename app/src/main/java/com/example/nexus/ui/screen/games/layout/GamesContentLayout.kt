package com.example.nexus.ui.screen.games.layout

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
import com.example.nexus.ui.components.lazyrow.MoviesLazyRow
import com.example.nexus.ui.components.lazyrow.SeriesLazyRow
import com.example.nexus.ui.components.shimmer.MoviesRowShimmer
import com.example.nexus.ui.components.shimmer.SeriesRowShimmer
import com.example.nexus.ui.screen.games.GamesRow
import com.example.nexus.ui.screen.games.GamesState
import com.example.nexus.ui.screen.movies.MoviesCategory
import com.example.nexus.ui.screen.series.SeriesCategory

@Composable
fun GamesContentLayout(
    rows: List<GamesRow>,
    moviesMap: Map<MoviesCategory, GamesState<Movie>>,
    seriesMap: Map<SeriesCategory, GamesState<Series>>,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(top = 16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        items(rows) { row ->
            when (row) {
                is GamesRow.MoviesRow -> {
                    val gamesState = moviesMap[row.category]
                    when (gamesState) {
                        null, is GamesState.Loading -> MoviesRowShimmer(row.category.title)
                        is GamesState.Success -> MoviesLazyRow(row.category.title, movies = gamesState.items)
                        is GamesState.Error -> MoviesRowShimmer(row.category.title)
                    }
                }

                is GamesRow.SeriesRow -> {
                    val gamesState = seriesMap[row.category]
                    when (gamesState) {
                        null, is GamesState.Loading -> SeriesRowShimmer(row.category.title)
                        is GamesState.Success -> SeriesLazyRow(row.category.title, seriesList = gamesState.items)
                        is GamesState.Error -> SeriesRowShimmer(row.category.title)
                    }
                }
            }
        }
    }
}
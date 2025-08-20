package com.example.nexus.ui.screen.home.layout

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
import com.example.nexus.ui.screen.home.HomeRow
import com.example.nexus.ui.screen.home.HomeState
import com.example.nexus.ui.screen.movies.MoviesCategory
import com.example.nexus.ui.screen.series.SeriesCategory

@Composable
fun HomeContentLayout(
    rows: List<HomeRow>,
    moviesMap: Map<MoviesCategory, HomeState<Movie>>,
    seriesMap: Map<SeriesCategory, HomeState<Series>>,
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
                is HomeRow.MoviesRow -> {
                    val homeState = moviesMap[row.category]
                    when (homeState) {
                        null, is HomeState.Loading -> MoviesRowShimmer(row.category.title)
                        is HomeState.Success -> MoviesLazyRow(row.category.title, movies = homeState.items)
                        is HomeState.Error -> MoviesRowShimmer(row.category.title)
                    }
                }

                is HomeRow.SeriesRow -> {
                    val homeState = seriesMap[row.category]
                    when (homeState) {
                        null, is HomeState.Loading -> SeriesRowShimmer(row.category.title)
                        is HomeState.Success -> SeriesLazyRow(row.category.title, seriesList = homeState.items)
                        is HomeState.Error -> SeriesRowShimmer(row.category.title)
                    }
                }
            }
        }
    }

}
package com.example.nexus.ui.screens.series

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.nexus.ui.components.card.SerieCardLarge
import com.example.nexus.ui.components.lazyrow.SeriesLazyRow
import com.example.nexus.ui.theme.Dimens

@Composable
fun SeriesLayout(
    featuredSerieState: SeriesState,
    seriesUiState: SeriesUiState,
    categories: List<SerieCategory>,
    onSerieClick: (Int) -> Unit,
    modifier: Modifier
) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(top = Dimens.Padding.huge),
        verticalArrangement = Arrangement.spacedBy(Dimens.Spacing.jumbo),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            when (featuredSerieState) {
                is SeriesState.Loading -> {  }
                is SeriesState.Success -> {
                    val featuredSerie = featuredSerieState.results.random()
                    SerieCardLarge(
                        serie = featuredSerie,
                        onSerieClick = onSerieClick
                    )
                }
                is SeriesState.Error -> {  }
            }
        }

        items(categories) { category ->
            val seriesMap = seriesUiState.seriesMap
            val seriesState = seriesMap[category]
            when (seriesState) {
                null, is SeriesState.Loading -> {  }
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
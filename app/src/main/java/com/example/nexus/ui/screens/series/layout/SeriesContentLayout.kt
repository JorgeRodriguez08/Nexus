package com.example.nexus.ui.screens.series.layout

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.nexus.domain.model.Serie
import com.example.nexus.ui.components.card.SeriesCardLarge
import com.example.nexus.ui.components.lazyrow.SeriesLazyRow
import com.example.nexus.ui.components.shimmer.SeriesCardLargeShimmer
import com.example.nexus.ui.components.shimmer.SeriesRowShimmer
import com.example.nexus.ui.screens.series.SeriesCategory
import com.example.nexus.ui.screens.series.SeriesState

@Composable
fun SeriesContentLayout(
    featuredState: SeriesState<Serie>,
    serieUiState: Map<SeriesCategory, SeriesState<Serie>>,
    categories: List<SeriesCategory>,
    onSeriesClick: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(top = 16.dp),
        verticalArrangement = Arrangement.spacedBy(3.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            when (featuredState) {
                is SeriesState.Loading -> { SeriesCardLargeShimmer() }
                is SeriesState.Success -> {
                    val featured = featuredState.items.random()
                    SeriesCardLarge(featured, onSeriesClick = onSeriesClick)
                }
                is SeriesState.Error -> { SeriesCardLargeShimmer() }
            }
        }

        items(categories) { category ->
            val seriesState = serieUiState[category]
            when (seriesState) {
                null, is SeriesState.Loading -> { SeriesRowShimmer(category.title)}
                is SeriesState.Success -> { SeriesLazyRow(category.title, seriesState.items, onSeriesClick = onSeriesClick) }
                is SeriesState.Error -> { SeriesRowShimmer(category.title) }
            }
        }
    }
}
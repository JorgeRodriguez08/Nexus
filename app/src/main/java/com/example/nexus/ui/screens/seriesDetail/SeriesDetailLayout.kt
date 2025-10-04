package com.example.nexus.ui.screens.seriesDetail

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.nexus.domain.model.Series

@Composable
fun SeriesDetailLayout(
    seriesState: SeriesState<Series>,
    modifier: Modifier = Modifier
) {
    when (seriesState) {
        is SeriesState.Loading -> { SeriesDetailCardShimmer() }
        is SeriesState.Success -> { SeriesDetailCard(series = seriesState.item) }
        is SeriesState.Error -> { SeriesDetailCardShimmer() }
    }
}
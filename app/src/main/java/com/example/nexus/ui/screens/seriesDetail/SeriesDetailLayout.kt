package com.example.nexus.ui.screens.seriesDetail

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.nexus.domain.model.SerieDetails

@Composable
fun SeriesDetailLayout(
    serieState: SeriesState<SerieDetails>,
    modifier: Modifier = Modifier
) {
    when (serieState) {
        is SeriesState.Loading -> { SeriesDetailCardShimmer() }
        is SeriesState.Success -> { SeriesDetailCard(serieDetails = serieState.item) }
        is SeriesState.Error -> { SeriesDetailCardShimmer() }
    }
}
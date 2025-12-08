package com.example.nexus.ui.screens.serieDetail

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.nexus.domain.models.Serie

@Composable
fun SeriesDetailLayout(
    seriesState: SerieDetailsState<Serie>,
    modifier: Modifier = Modifier
) {
    when (seriesState) {
        is SerieDetailsState.Loading -> { SeriesDetailCardShimmer() }
        is SerieDetailsState.Success -> { SeriesDetailCard(series = seriesState.item) }
        is SerieDetailsState.Error -> { SeriesDetailCardShimmer() }
    }
}
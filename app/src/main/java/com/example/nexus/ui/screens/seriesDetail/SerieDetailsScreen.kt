package com.example.nexus.ui.screens.seriesDetail

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier

@Composable
fun SerieDetailsScreen(
    serieDetailsViewModel: SerieDetailsViewModel,
    serieId: Int,
    modifier: Modifier = Modifier
) {
    LaunchedEffect(Unit) {
        serieDetailsViewModel.loadSeriesDetail(seriesId = serieId)
    }

    val seriesDetailState = serieDetailsViewModel.serieDetailState.collectAsState().value
    SeriesDetailLayout(seriesDetailState, modifier = modifier)
}


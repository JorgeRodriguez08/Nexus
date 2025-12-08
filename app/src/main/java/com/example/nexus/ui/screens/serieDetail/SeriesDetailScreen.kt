package com.example.nexus.ui.screens.serieDetail

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier

@Composable
fun SeriesDetailScreen(
    seriesDetailViewModel: SeriesDetailViewModel,
    serieId: Int,
    modifier: Modifier = Modifier
) {
    LaunchedEffect(Unit) {
        seriesDetailViewModel.loadSeriesDetail(seriesId = serieId)
    }

    val seriesDetailState = seriesDetailViewModel.seriesDetailState.collectAsState().value
    SeriesDetailLayout(seriesDetailState, modifier = modifier)
}


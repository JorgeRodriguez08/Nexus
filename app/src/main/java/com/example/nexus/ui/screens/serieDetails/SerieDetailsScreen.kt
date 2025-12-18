package com.example.nexus.ui.screens.serieDetails

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
    val seriesDetailState = serieDetailsViewModel.serieDetailState.collectAsState().value

    LaunchedEffect(serieId) {
        serieDetailsViewModel.loadSerieDetails(serieId)
    }

    SerieDetailsLayout(
        serieDetailState = seriesDetailState,
        modifier = modifier
    )
}
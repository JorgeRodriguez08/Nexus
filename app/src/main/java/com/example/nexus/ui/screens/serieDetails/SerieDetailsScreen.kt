package com.example.nexus.ui.screens.serieDetails

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier

@Composable
fun SerieDetailsScreen(
    serieId: Int,
    serieDetailsViewModel: SerieDetailsViewModel,
    modifier: Modifier = Modifier
) {
    val serieIntegratedState = serieDetailsViewModel.serieIntegratedState.collectAsState().value
    val selectedSeasonNumber = serieDetailsViewModel.selectedSeasonNumber.collectAsState().value
    val seasonDetailsState = serieDetailsViewModel.seasonDetailsState.collectAsState().value

    LaunchedEffect(serieId) {
        serieDetailsViewModel.loadSerieIntegrated(serieId)
    }

    SerieDetailsLayout(
        serieIntegratedState = serieIntegratedState,
        selectedSeasonNumber = selectedSeasonNumber,
        seasonDetailsState = seasonDetailsState,
        onSeasonClick = { serieDetailsViewModel.changeSeason(it) },
        modifier = modifier
    )
}
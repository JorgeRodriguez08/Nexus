package com.example.nexus.ui.screens.serieDetails

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.nexus.ui.components.card.serie.SerieDetailsCard

@Composable
fun SerieDetailsLayout(
    serieDetailState: SerieDetailState,
    modifier: Modifier = Modifier
) {
    when (serieDetailState) {
        is SerieDetailState.Loading -> { }
        is SerieDetailState.Success -> {
            SerieDetailsCard(
                serieDetails = serieDetailState.serieDetails,
                modifier = modifier
            )
        }
        is SerieDetailState.Error -> { }
    }
}
package com.example.nexus.ui.screens.serieDetails

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.nexus.ui.components.buttons.ButtonDropDown
import com.example.nexus.ui.components.card.serie.SerieDetailsCard

@Composable
fun SerieDetailsLayout(
    serieIntegratedState: SerieIntegratedState,
    selectedSeasonNumber: Int,
    seasonDetailsState: SeasonDetailsState,
    onSeasonClick: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = Modifier.padding(bottom = 8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        item {
            when (serieIntegratedState) {
                is SerieIntegratedState.Loading -> { }
                is SerieIntegratedState.Success -> {
                    SerieDetailsCard(
                        serieIntegrated = serieIntegratedState.serieIntegrated,
                        selectedSeasonNumber = selectedSeasonNumber,
                        onSeasonClick = onSeasonClick,
                        modifier = modifier
                    )
                }
                is SerieIntegratedState.Error -> { }
            }
        }

        item {
            when (seasonDetailsState) {
                is SeasonDetailsState.Loading -> {}
                is SeasonDetailsState.Success -> {
                    seasonDetailsState.seasonDetails.episodes.forEach { episode ->
                        EpisodeDetailsRow(
                            episode = episode,
                        )
                    }
                }
                is SeasonDetailsState.Error -> {}
            }
        }
    }
}
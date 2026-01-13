package com.example.nexus.ui.screens.search

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.nexus.domain.model.Serie
import com.example.nexus.ui.theme.Dimens

@Composable
fun SeriesSection(
    series: List<Serie>,
    onSerieClick: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(Dimens.Padding.medium)
    ) {
        series.forEach { serie ->
            SerieRecommended(
                serie = serie,
                onSerieClick = onSerieClick,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}
package com.example.nexus.ui.screens.newsPopular

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.nexus.domain.model.Serie
import com.example.nexus.ui.screens.serieDetails.SerieIntegratedState
import com.example.nexus.ui.theme.Dimens

@Composable
fun NewsSerieLayout(
    series: List<Serie>,
    seriesDetailsStates: Map<Int, SerieIntegratedState>,
    onSerieClick: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    val filterSeries = series.filter { serie ->
        val filterState = seriesDetailsStates[serie.id]
        when (filterState) {
            is SerieIntegratedState.Loading -> true
            is SerieIntegratedState.Success -> {
                filterState.serieIntegrated.logo != null
            }
            else -> false
        }
    }

    LazyColumn(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(Dimens.Padding.extraExtraLarge),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        items(filterSeries, key = { it.id }) { serie ->
            val serieDetailsState = seriesDetailsStates[serie.id]
            when (serieDetailsState) {
                null, is SerieIntegratedState.Loading -> {  }
                is SerieIntegratedState.Success -> {
                    NewsSerieCard(
                        serieIntegrated = serieDetailsState.serieIntegrated,
                        onSerieClick = onSerieClick
                    )
                }
                is SerieIntegratedState.Error -> {  }
            }
        }
    }
}
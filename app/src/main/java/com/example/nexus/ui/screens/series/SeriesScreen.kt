package com.example.nexus.ui.screens.series

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier

@Composable
fun SeriesScreen(
    seriesViewModel: SeriesViewModel,
    onSerieClick: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    val featuredSerieState = seriesViewModel.featuredSeriesState.collectAsState().value
    val seriesUiState = seriesViewModel.seriesUiState.collectAsState().value

    SeriesLayout(
        featuredSerieState = featuredSerieState,
        seriesUiState = seriesUiState,
        categories = SeriesCategories.seriesCategories,
        onSerieClick = onSerieClick,
        modifier = modifier,
    )
}
package com.example.nexus.ui.screens.series

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import com.example.nexus.ui.screens.series.layout.SeriesContentLayout

@Composable
fun SeriesScreen(
    seriesViewModel: SeriesViewModel,
    onSerieClick: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    val featuredSeriesState = seriesViewModel.featuredSerieState.collectAsState()
    val uiState = seriesViewModel.uiState.collectAsState()
    val seriesUiState = uiState.value.serieUiState

    LaunchedEffect(Unit) {
        seriesViewModel.loadFeaturedSeries()
        seriesViewModel.loadSeriesContent()
    }

    SeriesContentLayout(
        featuredState = featuredSeriesState.value,
        serieUiState = seriesUiState,
        categories = seriesViewModel.seriesCategories,
        onSeriesClick = onSerieClick,
        modifier = modifier
    )
}
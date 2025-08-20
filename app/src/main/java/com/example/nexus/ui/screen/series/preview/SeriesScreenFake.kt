package com.example.nexus.ui.screen.series.preview

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.nexus.domain.model.Series
import com.example.nexus.ui.screen.series.SeriesCategories
import com.example.nexus.ui.screen.series.SeriesCategory
import com.example.nexus.ui.screen.series.SeriesState
import com.example.nexus.ui.screen.series.layout.SeriesContentLayout

@Composable
fun SeriesScreenFake(modifier: Modifier = Modifier) {
    val fakeSeries = List(10) { index ->
        Series(
            id = index,
            title = "Serie $index",
            overview = "Resumen de la serie $index",
            posterUrl = "",
            backdropUrl = "",
            voteAverage = 8.5,
            firstAirDate = "2025-01-01"
        )
    }

    val seriesCategories = SeriesCategories.seriesCategories
    val fakeSeriesUiState: Map<SeriesCategory, SeriesState<Series>> = seriesCategories.associate {
        it to SeriesState.Success(fakeSeries)
    }
    val fakeFeaturedState = SeriesState.Success(fakeSeries)

    SeriesContentLayout(
        featuredState = fakeFeaturedState,
        seriesUiState = fakeSeriesUiState,
        categories = seriesCategories,
        modifier = modifier
    )
}
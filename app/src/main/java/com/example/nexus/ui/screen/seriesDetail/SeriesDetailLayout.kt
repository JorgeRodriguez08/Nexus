package com.example.nexus.ui.screen.seriesDetail

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.nexus.domain.model.Movie
import com.example.nexus.domain.model.Series
import com.example.nexus.ui.screen.movieDetail.MovieDetailCard
import com.example.nexus.ui.screen.movieDetail.MovieDetailCardShimmer
import com.example.nexus.ui.screen.movieDetail.MovieState

@Composable
fun SeriesDetailLayout(
    seriesState: SeriesState<Series>,
    modifier: Modifier = Modifier
) {
    when (seriesState) {
        is SeriesState.Loading -> { SeriesDetailCardShimmer() }
        is SeriesState.Success -> { SeriesDetailCard(series = seriesState.item) }
        is SeriesState.Error -> { SeriesDetailCardShimmer() }
    }
}
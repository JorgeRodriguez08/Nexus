package com.example.nexus.ui.screens.series

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.nexus.ui.components.card.serie.SerieCardLarge
import com.example.nexus.ui.components.lazyrow.series.SeriesLazyRow
import com.example.nexus.ui.components.lazyrow.series.SeriesMediumLazyRow
import com.example.nexus.ui.components.lazyrow.series.SeriesRegularLazyRow
import com.example.nexus.ui.components.lazyrow.series.SeriesTop10LazyRow
import com.example.nexus.ui.shimmer.card.serie.SerieCardLargeShimmer
import com.example.nexus.ui.shimmer.lazyrow.series.SeriesLazyRowShimmer
import com.example.nexus.ui.shimmer.lazyrow.series.SeriesMediumLazyRowShimmer
import com.example.nexus.ui.shimmer.lazyrow.series.SeriesRegularLazyRowShimmer
import com.example.nexus.ui.shimmer.lazyrow.series.SeriesTop10LazyRowShimmer
import com.example.nexus.ui.theme.Dimens

@Composable
fun SeriesLayout(
    featuredSerieState: SeriesState,
    seriesUiState: SeriesUiState,
    categories: List<SerieCategory>,
    onSerieClick: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(
                top = Dimens.Padding.sectionSmall,
                bottom = Dimens.Padding.sectionExtraLarge
            ),
        verticalArrangement = Arrangement.spacedBy(Dimens.Padding.extraExtraLarge),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            when (featuredSerieState) {
                is SeriesState.Loading -> {
                    SerieCardLargeShimmer()
                }
                is SeriesState.Success -> {
                    val featuredSerie = featuredSerieState.results.first()
                    SerieCardLarge(
                        serie = featuredSerie,
                        onSerieClick = onSerieClick
                    )
                }
                is SeriesState.Error -> {
                    SerieCardLargeShimmer()
                }
            }
        }

        items(categories) { category ->
            val seriesMap = seriesUiState.seriesMap
            val seriesState = seriesMap[category]
            when (seriesState) {
                null, is SeriesState.Loading, is SeriesState.Error -> {
                    when (category) {
                        is SerieCategory.OnTheAir -> {
                            SeriesMediumLazyRowShimmer(
                                title = category.title
                            )
                        }
                        is SerieCategory.OnlyNexus -> {
                            SeriesRegularLazyRowShimmer(
                                title = category.title
                            )
                        }
                        is SerieCategory.Trending -> {
                            SeriesTop10LazyRowShimmer(
                                title = category.title
                            )
                        }
                        is SerieCategory.AiringToday -> {
                            SeriesMediumLazyRowShimmer(
                                title = category.title
                            )
                        }
                        else -> {
                            SeriesLazyRowShimmer(
                                title = category.title
                            )
                        }
                    }
                }

                is SeriesState.Success -> {
                    when (category) {
                        is SerieCategory.OnTheAir -> {
                            SeriesMediumLazyRow(
                                title = category.title,
                                series = seriesState.results,
                                onSerieClick = onSerieClick
                            )
                        }
                        is SerieCategory.OnlyNexus -> {
                            SeriesRegularLazyRow(
                                title = category.title,
                                series = seriesState.results,
                                onSerieClick = onSerieClick
                            )
                        }
                        is SerieCategory.Trending -> {
                            SeriesTop10LazyRow(
                                title = category.title,
                                series = seriesState.results,
                                onSerieClick = onSerieClick,
                            )
                        }
                        is SerieCategory.AiringToday -> {
                            SeriesMediumLazyRow(
                                title = category.title,
                                series = seriesState.results,
                                onSerieClick = onSerieClick
                            )
                        }
                        else -> {
                            SeriesLazyRow(
                                title = category.title,
                                series = seriesState.results,
                                onSerieClick = onSerieClick
                            )
                        }
                    }
                }
            }
        }
    }
}
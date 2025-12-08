package com.example.nexus.domain.usecase.series

data class SeriesUseCase(
    val getSeriesTrending: GetSeriesTrendingUseCase,
    val getSeriesAiringToday: GetSeriesAiringTodayUseCase,
    val getSeriesOnTheAir: GetSeriesOnTheAirUseCase,
    val getSeriesPopular: GetSeriesPopularUseCase,
    val getSeriesTopRated: GetSeriesTopRatedUseCase,
    val discoverSeries: DiscoverSeriesUseCase,
    val searchSeries: SearchSerieUseCase,
    val getSerieDetails: GetSerieDetailsUseCase
)
package com.example.nexus.domain.usecase.series

data class SeriesUseCase(
    val getSeriesAiringToday: GetSeriesAiringTodayUseCase,
    val getSeriesOnTheAir: GetSeriesOnTheAirUseCase,
    val getSeriesPopular: GetSeriesPopularUseCase,
    val getSeriesTopRated: GetSeriesTopRatedUseCase,
    val getSeriesByGenre: GetSeriesByGenreUseCase,
    val getSeriesById: GetSeriesByIdUseCase,
    val searchSeries: SearchSeriesUseCase
)
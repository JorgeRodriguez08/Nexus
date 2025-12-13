package com.example.nexus.di

import com.example.nexus.domain.usecase.series.DiscoverSeriesUseCase
import com.example.nexus.domain.usecase.series.GetSerieDetailsUseCase
import com.example.nexus.domain.usecase.series.GetSeriesAiringTodayUseCase
import com.example.nexus.domain.usecase.series.GetSeriesOnTheAirUseCase
import com.example.nexus.domain.usecase.series.GetSeriesPopularUseCase
import com.example.nexus.domain.usecase.series.GetSeriesTopRatedUseCase
import com.example.nexus.domain.usecase.series.GetSeriesTrendingUseCase
import com.example.nexus.domain.usecase.series.SearchSerieUseCase
import com.example.nexus.domain.usecase.series.SeriesUseCase
import org.koin.dsl.module

val seriesDomainModule = module {
    factory { GetSeriesTrendingUseCase(get()) }
    factory { GetSeriesAiringTodayUseCase(get()) }
    factory { GetSeriesOnTheAirUseCase(get()) }
    factory { GetSeriesPopularUseCase(get()) }
    factory { GetSeriesTopRatedUseCase(get()) }
    factory { DiscoverSeriesUseCase(get()) }
    factory { SearchSerieUseCase(get()) }
    factory { GetSerieDetailsUseCase(get()) }

    factory {
        SeriesUseCase(
            getSeriesTrending = get(),
            getSeriesAiringToday = get(),
            getSeriesOnTheAir = get(),
            getSeriesPopular = get(),
            getSeriesTopRated = get(),
            discoverSeries = get(),
            searchSerie = get(),
            getSerieDetails = get()
        )
    }
}
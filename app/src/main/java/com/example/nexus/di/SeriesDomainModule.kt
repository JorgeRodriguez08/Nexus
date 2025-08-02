package com.example.nexus.di

import com.example.nexus.domain.usecase.series.GetSeriesAiringTodayUseCase
import com.example.nexus.domain.usecase.series.GetSeriesByGenreUseCase
import com.example.nexus.domain.usecase.series.GetSeriesByIdUseCase
import com.example.nexus.domain.usecase.series.GetSeriesOnTheAirUseCase
import com.example.nexus.domain.usecase.series.GetSeriesPopularUseCase
import com.example.nexus.domain.usecase.series.GetSeriesTopRatedUseCase
import com.example.nexus.domain.usecase.series.SearchSeriesUseCase
import com.example.nexus.domain.usecase.series.SeriesUseCase
import org.koin.dsl.module

val seriesDomainModule = module {

    factory { GetSeriesAiringTodayUseCase(get()) }
    factory { GetSeriesOnTheAirUseCase(get()) }
    factory { GetSeriesPopularUseCase(get()) }
    factory { GetSeriesTopRatedUseCase(get()) }
    factory { GetSeriesByGenreUseCase(get()) }
    factory { GetSeriesByIdUseCase(get()) }
    factory { SearchSeriesUseCase(get()) }

    factory {
        SeriesUseCase(
            getSeriesAiringToday = get(),
            getSeriesOnTheAir = get(),
            getSeriesPopular = get(),
            getSeriesTopRated = get(),
            getSeriesByGenre = get(),
            getSeriesById = get(),
            searchSeries = get()
        )
    }

}


package com.example.nexus.di

import com.example.nexus.domain.usecase.GetMovieByIdUseCase
import com.example.nexus.domain.usecase.GetMoviesByGenreUseCase
import com.example.nexus.domain.usecase.GetMoviesUseCase
import com.example.nexus.domain.usecase.GetSeriesByGenreUseCase
import com.example.nexus.domain.usecase.GetSeriesByIdUseCase
import com.example.nexus.domain.usecase.GetSeriesUseCase
import com.example.nexus.domain.usecase.SearchMoviesUseCase
import com.example.nexus.domain.usecase.SearchSeriesUseCase
import org.koin.dsl.module

val domainModule = module {
    factory { GetMoviesUseCase(get()) }
    factory { GetMovieByIdUseCase(get()) }
    factory { SearchMoviesUseCase(get()) }
    factory { GetMoviesByGenreUseCase(get()) }

    factory { GetSeriesUseCase(get()) }
    factory { GetSeriesByIdUseCase(get()) }
    factory { SearchSeriesUseCase(get()) }
    factory { GetSeriesByGenreUseCase(get()) }
}
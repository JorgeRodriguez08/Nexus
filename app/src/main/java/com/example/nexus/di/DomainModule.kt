package com.example.nexus.di

import com.example.nexus.domain.repository.MovieRepository
import com.example.nexus.data.repository.MovieRepositoryImpl
import com.example.nexus.domain.repository.SeriesRepository
import com.example.nexus.data.repository.SeriesRepositoryImpl
import com.example.nexus.domain.usecase.GetPopularMoviesUseCase
import com.example.nexus.domain.usecase.GetPopularMoviesUseCaseImpl
import com.example.nexus.domain.usecase.GetMovieDetailsUseCase
import com.example.nexus.domain.usecase.GetMovieDetailsUseCaseImpl
import com.example.nexus.domain.usecase.SearchMoviesUseCase
import com.example.nexus.domain.usecase.SearchMoviesUseCaseImpl
import com.example.nexus.domain.usecase.GetPopularSeriesUseCase
import com.example.nexus.domain.usecase.GetPopularSeriesUseCaseImpl
import com.example.nexus.domain.usecase.GetSeriesDetailsUseCase
import com.example.nexus.domain.usecase.GetSeriesDetailsUseCaseImpl
import com.example.nexus.domain.usecase.SearchSeriesUseCase
import com.example.nexus.domain.usecase.SearchSeriesUseCaseImpl
import org.koin.dsl.module

val domainModule = module {
    // Movies
    factory<GetPopularMoviesUseCase> { GetPopularMoviesUseCaseImpl(get()) }
    factory<GetMovieDetailsUseCase> { GetMovieDetailsUseCaseImpl(get()) }
    factory<SearchMoviesUseCase> { SearchMoviesUseCaseImpl(get())}

    // Series
    factory<GetPopularSeriesUseCase> { GetPopularSeriesUseCaseImpl(get()) }
    factory<GetSeriesDetailsUseCase> { GetSeriesDetailsUseCaseImpl(get()) }
    factory<SearchSeriesUseCase> { SearchSeriesUseCaseImpl(get())}
}
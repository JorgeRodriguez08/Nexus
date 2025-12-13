package com.example.nexus.di

import com.example.nexus.data.repository.impl.MoviesRepositoryImpl
import com.example.nexus.domain.repository.movies.MoviesRepository
import com.example.nexus.data.repository.impl.SeriesRepositoryImpl
import com.example.nexus.domain.repository.series.SeriesRepository

import org.koin.dsl.module

val dataModule = module {
    single<MoviesRepository> { MoviesRepositoryImpl(get()) }
    single<SeriesRepository> { SeriesRepositoryImpl(get()) }
}


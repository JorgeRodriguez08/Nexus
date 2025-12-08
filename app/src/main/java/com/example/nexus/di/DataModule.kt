package com.example.nexus.di

import com.example.nexus.data.repository.MoviesRepositoryImpl
import com.example.nexus.domain.repository.MoviesRepository
import com.example.nexus.data.repository.SeriesRepositoryImpl
import com.example.nexus.domain.repository.SeriesRepository

import org.koin.dsl.module

val dataModule = module {
    single<MoviesRepository> { MoviesRepositoryImpl(get()) }
    single<SeriesRepository> { SeriesRepositoryImpl(get()) }
}


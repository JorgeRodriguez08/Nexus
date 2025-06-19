package com.example.nexus.di

import com.example.nexus.data.repository.MovieRepositoryImpl
import com.example.nexus.domain.repository.MovieRepository
import com.example.nexus.data.repository.SeriesRepositoryImpl
import com.example.nexus.domain.repository.SeriesRepository

import org.koin.dsl.module

val dataModule = module {
    single<MovieRepository> {MovieRepositoryImpl(get())}
    single<SeriesRepository> {SeriesRepositoryImpl(get())}
}


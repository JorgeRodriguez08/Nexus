package com.example.nexus.di

import com.example.nexus.ui.screen.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel {
        HomeViewModel(
            getMoviesUseCase = get(),
            getMovieByIdUseCase = get(),
            searchMoviesUseCase = get(),
            getMoviesByGenreUseCase = get(),
            getSeriesUseCase = get(),
            getSeriesByIdUseCase = get(),
            searchSeriesUseCase = get(),
            getSeriesByGenreUseCase = get()
        )
    }
}
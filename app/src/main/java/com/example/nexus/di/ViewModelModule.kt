package com.example.nexus.di

import com.example.nexus.ui.navigation.NavigationViewModel
import com.example.nexus.ui.screen.movies.MoviesViewModel
import com.example.nexus.ui.screen.series.SeriesViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {

    viewModel { NavigationViewModel() }
    viewModel { SeriesViewModel(seriesUseCase = get()) }
    viewModel { MoviesViewModel(moviesUseCase = get()) }
}
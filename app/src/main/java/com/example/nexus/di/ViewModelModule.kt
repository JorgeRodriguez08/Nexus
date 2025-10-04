package com.example.nexus.di

import com.example.nexus.ui.navigation.NavigationViewModel
import com.example.nexus.ui.screens.movieDetail.MovieDetailViewModel
import com.example.nexus.ui.screens.games.GamesViewModel
import com.example.nexus.ui.screens.movies.MoviesViewModel
import com.example.nexus.ui.screens.series.SeriesViewModel
import com.example.nexus.ui.screens.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { NavigationViewModel() }
    viewModel { MoviesViewModel(moviesUseCase = get()) }
    viewModel { SeriesViewModel(seriesUseCase = get()) }
    viewModel { HomeViewModel(moviesUseCase = get(), seriesUseCase = get()) }
    viewModel { GamesViewModel(moviesUseCase = get(), seriesUseCase = get()) }
    viewModel { MovieDetailViewModel(moviesUseCase = get()) }
}
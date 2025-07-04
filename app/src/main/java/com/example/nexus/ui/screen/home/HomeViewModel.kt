package com.example.nexus.ui.screen.home

import androidx.lifecycle.ViewModel
import com.example.nexus.domain.usecase.GetMovieDetailsUseCase
import com.example.nexus.domain.usecase.GetPopularMoviesUseCase
import com.example.nexus.domain.usecase.GetPopularSeriesUseCase
import com.example.nexus.domain.usecase.GetSeriesDetailsUseCase
import com.example.nexus.domain.usecase.SearchMoviesUseCase
import com.example.nexus.domain.usecase.SearchSeriesUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import org.koin.androidx.compose.koinViewModel
import org.koin.android.ext.koin.androidContext
/*
class HomeViewModel(
    private val getPopularMoviesUseCase: GetPopularMoviesUseCase,
    private val getMoviesDetailsUseCase: GetMovieDetailsUseCase,
    private val searchMoviesUseCase: SearchMoviesUseCase,
    private val getPopularSeriesUseCase: GetPopularSeriesUseCase,
    private val getSeriesDetailsUseCase: GetSeriesDetailsUseCase,
    private val searchSeriesUseCase: SearchSeriesUseCase,
) : ViewModel() {

    private val _uiState = MutableStateFlow(HomeScreenState())
    val uiState: StateFlow<HomeScreenState>

}
*/

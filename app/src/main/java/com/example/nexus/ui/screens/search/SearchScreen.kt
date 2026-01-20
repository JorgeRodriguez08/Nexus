package com.example.nexus.ui.screens.search

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier

@Composable
fun SearchScreen(
    searchViewModel: SearchViewModel,
    onMovieClick: (Int) -> Unit,
    onSerieClick: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    val value = searchViewModel.value.collectAsState().value
    val searchMovieState = searchViewModel.searchMovieState.collectAsState().value
    val searchSerieState = searchViewModel.searchSerieState.collectAsState().value
    val gamesState = searchViewModel.gamesState.collectAsState().value
    val moviesState = searchViewModel.moviesState.collectAsState().value
    val seriesState = searchViewModel.seriesState.collectAsState().value

    Column() {
        SearchBar(
            value = value,
            onValueChange = { newValue -> searchViewModel.onValueChange(newValue) },
            modifier = Modifier
        )

        if (value.isEmpty()) {
            SearchLayout(
                gamesState = gamesState,
                moviesState = moviesState,
                seriesState = seriesState,
                onMovieClick = onMovieClick,
                onSerieClick = onSerieClick,
                modifier = modifier
            )
        } else {
            SearchResultsLayout(
                searchMovieState = searchMovieState,
                searchSerieState = searchSerieState,
                moviesState = moviesState,
                seriesState = seriesState,
                onMovieClick = onMovieClick,
                onSerieClick = onSerieClick,
                modifier = modifier
            )
        }
    }
}
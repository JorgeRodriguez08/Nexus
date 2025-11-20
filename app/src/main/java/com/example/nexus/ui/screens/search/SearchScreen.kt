package com.example.nexus.ui.screens.search

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import kotlinx.coroutines.delay

@Composable
fun SearchScreen(
    searchViewModel: SearchViewModel,
    modifier: Modifier = Modifier
) {
    val value = searchViewModel.value.collectAsState().value
    val searchState = searchViewModel.searchResultsState.collectAsState().value
    val gamesState = searchViewModel.gamesUiState.collectAsState().value
    val moviesState = searchViewModel.moviesUiState.collectAsState().value

    LaunchedEffect(Unit) {
        if (value.isEmpty()) {
            searchViewModel.loadGamesPopular()
            searchViewModel.loadMoviesPopular()
        }
    }

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
                modifier = modifier
            )
        } else {
            SearchResultsLayout(
                searchState = searchState,
                modifier = modifier
            )
        }
    }
}

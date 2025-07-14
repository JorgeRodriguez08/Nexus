package com.example.nexus.ui.screen.home

data class CategoryUiState<T>(
    val isLoading: Boolean = false,
    val items: List<T> = emptyList(),
    val error: String? = null
)

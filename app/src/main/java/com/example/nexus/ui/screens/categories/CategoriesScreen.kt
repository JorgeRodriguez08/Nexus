package com.example.nexus.ui.screens.categories

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun CategoriesScreen(modifier: Modifier = Modifier) {
    val categories = Categories.categories

    CategoriesLayout(
        categories = categories,
        modifier = modifier
    )
}
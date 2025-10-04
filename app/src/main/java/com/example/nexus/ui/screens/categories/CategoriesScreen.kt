package com.example.nexus.ui.screens.categories

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.nexus.ui.screens.categories.layout.CategoriesLayout

@Composable
fun CategoriesScreen(modifier: Modifier = Modifier) {
    val fakeCategories = Categories.categories

    CategoriesLayout(
        categories = fakeCategories,
        modifier = modifier
    )
}
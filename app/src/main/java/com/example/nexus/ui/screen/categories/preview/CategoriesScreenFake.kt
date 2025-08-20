package com.example.nexus.ui.screen.categories.preview

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.nexus.ui.screen.categories.Categories
import com.example.nexus.ui.screen.categories.layout.CategoriesLayout

@Composable
fun CategoriesScreenFake(modifier: Modifier = Modifier) {
    val fakeCategories = Categories.categories

    CategoriesLayout(
        categories = fakeCategories,
        modifier = modifier
    )
}
package com.example.nexus.ui.screens.categories

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import com.example.nexus.ui.theme.Dimens
import com.example.nexus.ui.theme.Strings

@Composable
fun CategoriesLayout(
    modifier: Modifier = Modifier,
    categories: List<Category>,
    onClick: () -> Unit = { }
) {
    LazyColumn(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(Dimens.Padding.extraLarge),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item() {
            Text(
                text = Strings.Categories.allCategories,
                color = MaterialTheme.colorScheme.onSurface,
                fontWeight = FontWeight.Companion.Bold,
                style = MaterialTheme.typography.headlineSmall
            )
        }

        items(categories) { category ->
            Text(
                text = category.title,
                modifier = Modifier.clickable(onClick = onClick),
                color = MaterialTheme.colorScheme.onSurface,
                style = MaterialTheme.typography.titleLarge,
            )
        }
    }
}
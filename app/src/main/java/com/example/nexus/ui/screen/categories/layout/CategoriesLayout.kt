package com.example.nexus.ui.screen.categories.layout

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
import androidx.compose.ui.unit.dp
import com.example.nexus.ui.screen.categories.Category

@Composable
fun CategoriesLayout(
    categories: List<Category>,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {}
) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
        ,
        verticalArrangement = Arrangement.spacedBy(13.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item() {
            Text(
                text = "Todas las Categorías",
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold

            )
        }
        items(categories) { category ->
            Text(
                text = category.title,
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier
                    .clickable(onClick = onClick)
            )
        }

    }

}


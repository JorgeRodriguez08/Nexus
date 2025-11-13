package com.example.nexus.ui.screens.newsPopular

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun NewsFilterBar(
    modifier: Modifier = Modifier,
    selectedFilter: FilterType,
    onNewFilterSelected: (FilterType) -> Unit

) {

    LazyRow(
        modifier = modifier.padding(start = 12.dp, end = 12.dp, top = 1.dp, bottom = 14.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        FilterType.values().forEach { filter ->
            item {
                FilterChip(
                    selected = filter == selectedFilter,
                    onClick = { onNewFilterSelected(filter) },
                    label = { Text(text = filter.label, fontSize = 14.sp) },
                    modifier = Modifier.height(40.dp),
                    shape = RoundedCornerShape(18.dp),
                    colors = FilterChipDefaults.filterChipColors(
                        containerColor = MaterialTheme.colorScheme.background,
                        selectedContainerColor = MaterialTheme.colorScheme.onSurface,
                        labelColor = MaterialTheme.colorScheme.onSurface,
                        selectedLabelColor = MaterialTheme.colorScheme.background
                    )
                )
            }
        }
    }
}
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
import com.example.nexus.ui.theme.Dimens
import com.example.nexus.ui.theme.FontSize

@Composable
fun NewsFilterBar(
    modifier: Modifier = Modifier,
    selectedFilter: FilterType,
    onNewFilterSelected: (FilterType) -> Unit
) {
    LazyRow(
        modifier = modifier.padding(
            start = Dimens.Padding.regular,
            end = Dimens.Padding.regular,
            top = Dimens.Padding.tiny,
            bottom = Dimens.Padding.large
        ),
        horizontalArrangement = Arrangement.spacedBy(Dimens.Spacing.medium)
    ) {
        FilterType.values().forEach { filter ->
            item {
                FilterChip(
                    selected = filter == selectedFilter,
                    onClick = { onNewFilterSelected(filter) },
                    label = { Text(text = filter.label, fontSize = FontSize.medium) },
                    modifier = Modifier.height(Dimens.Filter.small.height),
                    shape = RoundedCornerShape(Dimens.Radius.large),
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
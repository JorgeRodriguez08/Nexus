package com.example.nexus.ui.components.filterbar

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
import com.example.nexus.ui.theme.FontSizes

@Composable
fun NewsFilterBar(
    selectedNewFilter: NewFilterType,
    onNewFilterSelected: (NewFilterType) -> Unit,
    modifier: Modifier = Modifier,
) {
    LazyRow(
        modifier = modifier.padding(
            start = Dimens.Padding.large,
            end = Dimens.Padding.large,
            top = Dimens.Padding.hairline,
            bottom = Dimens.Padding.extraLarge
        ),
        horizontalArrangement = Arrangement.spacedBy(Dimens.Padding.medium)
    ) {
        NewFilterType.values().forEach { newFilter ->
            item {
                FilterChip(
                    selected = newFilter == selectedNewFilter,
                    onClick = { onNewFilterSelected(newFilter) },
                    label = { Text(text = newFilter.label, fontSize = FontSizes.bodySmall) },
                    modifier = Modifier.height(Dimens.Filters.small.height),
                    shape = RoundedCornerShape(Dimens.Radius.gigaLarge),
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
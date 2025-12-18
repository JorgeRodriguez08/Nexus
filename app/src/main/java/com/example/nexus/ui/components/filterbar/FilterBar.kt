package com.example.nexus.ui.components.filterbar

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import com.example.nexus.ui.navigation.Destinations
import com.example.nexus.ui.theme.Dimens
import com.example.nexus.ui.theme.FontSizes

@Composable
fun FilterBar(
    selectedFilter: String,
    onFilterSelected: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    val filters = Destinations.screensFilter

    val visibleFilters = when (selectedFilter) {
        Destinations.Movies.route -> listOf(filters[2])
        Destinations.Series.route -> listOf(filters[2])
        Destinations.Categories.route -> emptyList()
        else -> filters
    }

    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(
                horizontal = Dimens.Padding.extraExtraLarge,
                vertical = Dimens.Padding.small
            ),
        horizontalArrangement = Arrangement.spacedBy(Dimens.Padding.large)
    ) {
        val filterLarge = Dimens.Filters.large
        val filterMedium = Dimens.Filters.medium

        visibleFilters.forEach { filter ->
            FilterChip(
                selected = filter == selectedFilter,
                onClick = { onFilterSelected(filter) },
                label = {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = filter,
                            color = MaterialTheme.colorScheme.onSurface,
                            fontSize = FontSizes.labelMedium,
                            fontWeight = FontWeight.Bold
                        )
                    }
                },
                modifier =
                    if (filter == filters[2]) {
                        Modifier
                            .width(filterLarge.width)
                            .height(filterLarge.height)
                    } else {
                        Modifier
                            .width(filterMedium.width)
                            .height(filterMedium.height)
                    },
                colors = FilterChipDefaults.filterChipColors(
                    containerColor = MaterialTheme.colorScheme.onSecondaryContainer.copy(alpha = Dimens.Alpha.pressed),
                    labelColor = MaterialTheme.colorScheme.onSecondaryContainer,
                    selectedContainerColor = MaterialTheme.colorScheme.onSecondaryContainer.copy(alpha = Dimens.Alpha.medium)
                ),
                border = BorderStroke(
                    width = Dimens.Borders.thin,
                    color = MaterialTheme.colorScheme.onSecondaryContainer.copy(alpha = Dimens.Alpha.disabled)
                )
            )
        }
    }
}
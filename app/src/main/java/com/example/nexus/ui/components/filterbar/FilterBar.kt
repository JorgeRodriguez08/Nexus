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
import com.example.nexus.ui.navigation.Destinations.Companion.screensFilter
import com.example.nexus.ui.theme.Dimens
import com.example.nexus.ui.theme.FontSize

@Composable
fun FilterBar(
    modifier: Modifier = Modifier,
    selectedOption: String,
    options: List<String> = screensFilter,
    onOptionSelected: (String) -> Unit,
) {
    val visibleOptions = when (selectedOption) {
        options[0] -> listOf(options[2])
        options[1] -> listOf(options[2])
        options[2] -> listOf()
        else -> listOf(options[0], options[1], options[2])
    }

    val filterLarge = Dimens.Filter.large
    val filterMedium = Dimens.Filter.medium

    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(
                horizontal = Dimens.Padding.extraLarge,
                vertical = Dimens.Padding.medium
            ),
        horizontalArrangement = Arrangement.spacedBy(Dimens.Spacing.large)
    ) {
        visibleOptions.forEach { option ->
            FilterChip(
                selected = option == selectedOption,
                onClick = { onOptionSelected(option) },
                label = {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = option,
                            color = MaterialTheme.colorScheme.onSurface,
                            fontSize = FontSize.small,
                            fontWeight = FontWeight.Bold
                        )
                    }
                },
                modifier =
                    if (option == options[2]) {
                        Modifier
                            .width(filterLarge.width)
                            .height(filterLarge.height)
                    } else {
                        Modifier
                            .width(filterMedium.width)
                            .height(filterMedium.height)
                    },
                colors = FilterChipDefaults.filterChipColors(
                    containerColor = MaterialTheme.colorScheme.onSecondaryContainer.copy(alpha = Dimens.Alpha.EXTRA_SMALL),
                    labelColor = MaterialTheme.colorScheme.onSecondaryContainer,
                    selectedContainerColor = MaterialTheme.colorScheme.onSecondaryContainer.copy(alpha = Dimens.Alpha.MEDIUM)
                ),
                border = BorderStroke(
                    width = Dimens.Border.extraSmall,
                    color = MaterialTheme.colorScheme.onSecondaryContainer.copy(alpha = Dimens.Alpha.SMALL)
                )
            )
        }
    }
}

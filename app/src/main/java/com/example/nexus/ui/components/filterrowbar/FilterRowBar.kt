package com.example.nexus.ui.components.filterrowbar

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.nexus.ui.navigation.Destinations.Companion.screensFilter

@Composable
fun FilterRowBar(
    modifier: Modifier = Modifier,
    options: List<String> = screensFilter,
    onOptionSelected: (String) -> Unit,
    selectedOption: String
) {
    val visibleOptions = when (selectedOption) {
        options[0] -> listOf(options[2])
        options[1] -> listOf(options[2])
        options[2] -> listOf()
        else -> listOf(options[0], options[1], options[2])
    }

    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 5.dp),
        horizontalArrangement = Arrangement.spacedBy(13.dp)
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
                        Text(text = option, fontSize = 12.sp, fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.onSurface)
                    }

                },
                modifier = if (option == options[2]) {
                    Modifier
                        .width(110.dp)
                        .height(48.dp)
                } else {
                    Modifier
                        .width(88.dp)
                        .height(48.dp)
                }
                    ,
                border = BorderStroke(0.5.dp, MaterialTheme.colorScheme.onSecondaryContainer.copy(alpha = 0.50f)),
                colors = FilterChipDefaults.filterChipColors(
                    containerColor = MaterialTheme.colorScheme.onSecondaryContainer.copy(alpha = 0.20f),
                    selectedContainerColor = MaterialTheme.colorScheme.onSecondaryContainer.copy(alpha = 0.60f),
                    labelColor = MaterialTheme.colorScheme.onSecondaryContainer
                )
            )
        }
    }

}

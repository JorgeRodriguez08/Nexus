package com.example.nexus.ui.components.filterrowbar

import androidx.compose.material3.FilterChip
import androidx.compose.material3.Text
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.nexus.ui.navigation.screensFilter

@Composable
fun FilterRowBar(
    modifier: Modifier = Modifier,
    options: List<String> = screensFilter,
    onOptionSelected: (String) -> Unit = { },
    selectedOption: String = screensFilter.first()
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        options.forEach { option ->
            FilterChip(
                selected = option == selectedOption,
                onClick = { onOptionSelected(option) },
                label = { Text(option) }
            )
        }
    }
}
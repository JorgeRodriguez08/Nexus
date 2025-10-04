package com.example.nexus.ui.components.filterrowbar

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.nexus.ui.navigation.screensFilter

@Composable
fun FilterRowBar(
    modifier: Modifier = Modifier,
    options: List<String> = screensFilter,
    onOptionSelected: (String) -> Unit,
    selectedOption: String
) {
    val visibleOptions = when (selectedOption) {
        options[0] -> listOf(options[0], options[2])
        options[1] -> listOf(options[1], options[2])
        options[2] -> listOf(options[2])
        else -> listOf(options[0], options[1], options[2])
    }

    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 5.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        visibleOptions.forEach { option ->
            FilterChip(
                selected = option == selectedOption,
                onClick = { onOptionSelected(option) },
                label = { Text(text = option) }
            )
        }
    }

}

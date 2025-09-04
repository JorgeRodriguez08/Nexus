package com.example.nexus.ui.components.filterrowbar

import androidx.compose.material3.FilterChip
import androidx.compose.material3.Text
import androidx.compose.foundation.layout.*
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.nexus.ui.navigation.Dest
import com.example.nexus.ui.navigation.screensFilter

@Composable
fun FilterRowBar(
    modifier: Modifier = Modifier,
    options: List<String> = screensFilter,
    onOptionSelected: (String) -> Unit,
    selectedOption: String
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 5.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        when (selectedOption) {
            Dest.Series.route -> {
                FilterChip(
                    selected = options[0] == selectedOption,
                    onClick = { onOptionSelected(options[0]) },
                    label = { Text(options[0]) },
                    colors = FilterChipDefaults.filterChipColors(
                        containerColor = Color.White.copy(alpha = 0.05f),
                        selectedContainerColor = Color.White.copy(alpha = 0.6f),
                        labelColor = Color.White,
                        selectedLabelColor = Color.White
                    ),
                    modifier = Modifier.height(40.dp)
                )

                FilterChip(
                    selected = options[2] == selectedOption,
                    onClick = { onOptionSelected(options[2]) },
                    label = { Text(options[2]) },
                    colors = FilterChipDefaults.filterChipColors(
                        containerColor = Color.White.copy(alpha = 0.05f),
                        selectedContainerColor = Color.White.copy(alpha = 0.6f),
                        labelColor = Color.White,
                        selectedLabelColor = Color.White
                    ),
                    modifier = Modifier.height(40.dp)
                )
            }

            Dest.Movies.route -> {
                FilterChip(
                    selected = options[1] == selectedOption,
                    onClick = { onOptionSelected(options[1]) },
                    label = { Text(options[1]) },
                    colors = FilterChipDefaults.filterChipColors(
                        containerColor = Color.White.copy(alpha = 0.05f),
                        selectedContainerColor = Color.White.copy(alpha = 0.6f),
                        labelColor = Color.White,
                        selectedLabelColor = Color.White
                    ),
                    modifier = Modifier.height(40.dp)
                )

                FilterChip(
                    selected = options[2] == selectedOption,
                    onClick = { onOptionSelected(options[2]) },
                    label = { Text(options[2]) },
                    colors = FilterChipDefaults.filterChipColors(
                        containerColor = Color.White.copy(alpha = 0.05f),
                        selectedContainerColor = Color.White.copy(alpha = 0.6f),
                        labelColor = Color.White,
                        selectedLabelColor = Color.White
                    ),
                    modifier = Modifier.height(40.dp)
                )
            }

            Dest.Categories.route -> {
                FilterChip(
                    selected = options[2] == selectedOption,
                    onClick = { onOptionSelected(options[2]) },
                    label = { Text(options[2]) },
                    colors = FilterChipDefaults.filterChipColors(
                        containerColor = Color.White.copy(alpha = 0.05f),
                        selectedContainerColor = Color.White.copy(alpha = 0.6f),
                        labelColor = Color.White,
                        selectedLabelColor = Color.White
                    ),
                    modifier = Modifier.height(40.dp)
                )
            }

            else -> {
                FilterChip(
                    selected = options[0] == selectedOption,
                    onClick = { onOptionSelected(options[0]) },
                    label = { Text(options[0]) },
                    colors = FilterChipDefaults.filterChipColors(
                        containerColor = Color.White.copy(alpha = 0.05f),
                        selectedContainerColor = Color.White.copy(alpha = 0.6f),
                        labelColor = Color.White,
                        selectedLabelColor = Color.White
                    ),
                    modifier = Modifier.height(40.dp)
                )

                FilterChip(
                    selected = options[1] == selectedOption,
                    onClick = { onOptionSelected(options[1]) },
                    label = { Text(options[1]) },
                    colors = FilterChipDefaults.filterChipColors(
                        containerColor = Color.White.copy(alpha = 0.05f),
                        selectedContainerColor = Color.White.copy(alpha = 0.6f),
                        labelColor = Color.White,
                        selectedLabelColor = Color.White
                    ),
                    modifier = Modifier.height(40.dp)
                )

                FilterChip(
                    selected = options[2] == selectedOption,
                    onClick = { onOptionSelected(options[2]) },
                    label = { Text(options[2]) },
                    colors = FilterChipDefaults.filterChipColors(
                        containerColor = Color.White.copy(alpha = 0.05f),
                        selectedContainerColor = Color.White.copy(alpha = 0.6f),
                        labelColor = Color.White,
                        selectedLabelColor = Color.White
                    ),
                    modifier = Modifier.height(40.dp)
                )

            }
        }
    }
}

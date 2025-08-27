package com.example.nexus.ui.components.topappbar

import androidx.compose.foundation.layout.Column
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.nexus.R
import com.example.nexus.ui.components.filterrowbar.FilterRowBar
import com.example.nexus.ui.navigation.Dest

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NexusTopAppBar(
    modifier: Modifier = Modifier,
    currentRoute: String,
    canNavigateBack: Boolean = false,
    onSearchClick: () -> Unit,
    onBackClick: () -> Unit,
    onDownloadClick: () -> Unit,
    onFilterSelected: (String) -> Unit
) {
    Column {
        TopAppBar(
            title = { Text(text = "Nexus") },
            navigationIcon = {
                if (canNavigateBack) {
                    IconButton(onClick = onBackClick) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = stringResource(R.string.back_icon)
                        )
                    }
                } else {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = stringResource(R.string.nexus_icon)
                    )
                }
            },
            actions = {
                IconButton(onClick = onSearchClick) {
                    Icon(
                        imageVector = Icons.Filled.Search,
                        contentDescription = Dest.Search.route
                    )
                }
                IconButton(onClick = onDownloadClick) {
                    Icon(
                        imageVector = Icons.Filled.Add,
                        contentDescription = Dest.MyNexus.route
                    )
                }
            },
            modifier = modifier
        )

        FilterRowBar(
            selectedOption = currentRoute,
            onOptionSelected = onFilterSelected
        )
    }
}

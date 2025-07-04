package com.example.nexus.ui.composables.topappbar

    import android.content.res.Configuration
    import androidx.compose.material.icons.Icons
    import androidx.compose.material.icons.filled.Search
    import androidx.compose.material.icons.automirrored.filled.ArrowBack
    import androidx.compose.material.icons.filled.Add
    import androidx.compose.material3.ExperimentalMaterial3Api
    import androidx.compose.material3.Icon
    import androidx.compose.material3.IconButton
    import androidx.compose.material3.Text
    import androidx.compose.material3.TopAppBar
    import androidx.compose.runtime.Composable
    import androidx.compose.ui.Modifier
    import androidx.compose.ui.res.stringResource
    import androidx.compose.ui.tooling.preview.Preview
    import com.example.nexus.R
    import com.example.nexus.ui.theme.NexusTheme

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun NexusTopAppBar(
        modifier: Modifier = Modifier,
        title: String = "Nexus",
        canNavigateBack: Boolean = true,
        onBackClick: () -> Unit = {},
        onSearchClick: () -> Unit = {},
        onDownloadClick: () -> Unit = {}
    ) {
        TopAppBar(
            title = { Text(text = title) },
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
                IconButton(onClick = onDownloadClick) {
                    Icon(
                        imageVector = Icons.Filled.Add,
                        contentDescription = stringResource(R.string.search_icon)
                    )
                }
                IconButton(onClick = onSearchClick) {
                    Icon(
                        imageVector = Icons.Filled.Search,
                        contentDescription = stringResource(R.string.search_icon)
                    )
                }
            },
            modifier = modifier
        )
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Preview (
        showBackground = true,
        uiMode = Configuration.UI_MODE_NIGHT_YES
    )
    @Composable
    fun PreviewTopAppBar() {
        NexusTheme {
            NexusTopAppBar(
                title = "Nexus",
                canNavigateBack = true
            )
        }
    }
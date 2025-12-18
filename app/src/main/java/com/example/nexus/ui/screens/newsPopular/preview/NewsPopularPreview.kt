package com.example.nexus.ui.screens.newsPopular.preview

import android.content.res.Configuration
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.nexus.ui.theme.NexusTheme

@Composable
@Preview (showBackground = true, showSystemUi = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
fun NewsPopularPreview() {
    NexusTheme() {
        Scaffold(
            topBar = {}
        ) { innerPadding ->
            NewsPopularLayoutFake(modifier = Modifier.padding(innerPadding))
        }
    }
}
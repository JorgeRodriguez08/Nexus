package com.example.nexus.ui.screen.series.preview

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.nexus.ui.components.bottomappbar.NexusBottomAppBar
import com.example.nexus.ui.components.topappbar.NexusTopAppBar
import com.example.nexus.ui.navigation.NexusScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenWrapperPreview(
    modifier: Modifier = Modifier,
    content: @Composable (Modifier) -> Unit
) {
    Scaffold(
        topBar = { NexusTopAppBar(currentRoute = NexusScreen.Home.route,onSearchClick = { }, onBackClick = { }, onDownloadClick = { }, onFilterSelected = {})},
        bottomBar = { NexusBottomAppBar(onHome = { }, onGames = { }, onNewsAndPopular = { }, onMyNexus = { }) }
    ) { innerPadding ->
        content(modifier.padding(innerPadding))
    }
}
package com.example.nexus.ui.screen.newandpopular

import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.tooling.preview.Preview
import com.example.nexus.ui.composables.topappbar.NexusTopAppBar
import com.example.nexus.ui.composables.bottomappbar.NexusBottomAppBar
import com.example.nexus.ui.theme.NexusTheme
import android.content.res.Configuration
import androidx.compose.material3.Surface


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewAndPopularScreen(
    modifier: Modifier = Modifier
) {
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()

    Scaffold(
        modifier = modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            NexusTopAppBar()
        },
        bottomBar = {
            NexusBottomAppBar(modifier = modifier)
        }
    ) { innerPadding ->

        HomeBody(
            text = "Hello World",
            modifier = modifier.fillMaxSize(),
            contentPadding = innerPadding
        )
    }
}

@Composable
fun HomeBody(
    modifier: Modifier = Modifier,
    text: String,
    contentPadding: PaddingValues
) {
    Text(text = text)
}


@Preview (
    showBackground = true,
    showSystemUi = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
fun HomePreview() {
    NexusTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            NewAndPopularScreen()
        }
    }
}
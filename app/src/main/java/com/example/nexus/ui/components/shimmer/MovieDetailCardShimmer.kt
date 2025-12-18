package com.example.nexus.ui.components.shimmer

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp

@Composable
fun MovieDetailCardShimmer(
    modifier: Modifier = Modifier.Companion
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 10.dp),
        verticalArrangement = Arrangement.spacedBy(7.dp),
        horizontalAlignment = Alignment.Companion.Start
    ) {
        Card(
            modifier = modifier
                .fillMaxWidth()
                .aspectRatio(1.7f),
            shape = RectangleShape
        ) {

        }
    }
}
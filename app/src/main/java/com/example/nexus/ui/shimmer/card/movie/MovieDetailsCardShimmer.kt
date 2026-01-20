package com.example.nexus.ui.shimmer.card.movie

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.nexus.ui.components.buttons.ButtonLarge
import com.example.nexus.ui.shimmer.ShimmerDarkBox
import com.example.nexus.ui.theme.Dimens
import com.example.nexus.ui.theme.Strings

@Composable
fun MovieDetailsCardShimmer(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = Dimens.Padding.base)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(Dimens.Padding.extraSmall),
        horizontalAlignment = Alignment.Start
    ) {
        ShimmerDarkBox(
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(Dimens.AspectRatio.poster)
        )

        Spacer(modifier = Modifier.height(2.dp))

        ShimmerDarkBox(
            width = 255.dp,
            height = 35.dp,
            cornerRadius = 3.dp
        )

        Row(
            modifier = Modifier,
            horizontalArrangement = Arrangement.spacedBy(Dimens.Padding.base),
            verticalAlignment = Alignment.CenterVertically
        ) {
            ShimmerDarkBox(
                width = 40.dp,
                height = 20.dp,
                cornerRadius = 3.dp
            )
            
            ShimmerDarkBox(
                width = Dimens.Box.extraSmall.width,
                height = Dimens.Box.extraSmall.height
            )

            ShimmerDarkBox(
                width = 76.dp,
                height = 20.dp,
                cornerRadius = 3.dp
            )
        }

        Spacer(modifier = Modifier.height(2.dp))

        ButtonLarge(
            label = Strings.Labels.watch,
            enabled = true,
            modifier = modifier
        )

        ButtonLarge(
            label = Strings.Labels.download,
            enabled = false,
            modifier = modifier
        )

        Spacer(modifier = Modifier.height(12.dp))

        Column(verticalArrangement = Arrangement.spacedBy(3.dp)) {
            List(4) {
                ShimmerDarkBox(
                    modifier = Modifier.fillMaxWidth(),
                    height = 14.dp,
                    cornerRadius = 3.dp
                )
            }
        }

        Spacer(modifier = Modifier.height(1.dp))

        Column(verticalArrangement = Arrangement.spacedBy(3.dp)) {
            List(2) {
                ShimmerDarkBox(
                    modifier = Modifier.fillMaxWidth(),
                    height = 14.dp,
                    cornerRadius = 3.dp
                )
            }
        }

        Spacer(modifier = Modifier.height(1.dp))

        ShimmerDarkBox(
            width = 155.dp,
            height = 14.dp,
            cornerRadius = 3.dp
        )
    }
}
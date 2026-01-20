package com.example.nexus.ui.shimmer.card.serie

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.nexus.ui.shimmer.ShimmerDarkBox
import com.example.nexus.ui.theme.Dimens

@Composable
fun SerieCardMediumShimmer(
    modifier: Modifier = Modifier
) {
    ShimmerDarkBox(
        width = Dimens.Posters.medium.width,
        height = Dimens.Posters.medium.height,
        cornerRadius = Dimens.Radius.small
    )
}
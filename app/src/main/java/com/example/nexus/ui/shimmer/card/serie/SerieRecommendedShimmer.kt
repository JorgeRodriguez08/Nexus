package com.example.nexus.ui.shimmer.card.serie

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.nexus.R
import com.example.nexus.ui.shimmer.ShimmerDarkBox
import com.example.nexus.ui.theme.Dimens
import com.example.nexus.ui.theme.Strings

@Composable
fun SerieRecommendedShimmer(
    modifier: Modifier
) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically
    ) {
        ShimmerDarkBox(
            width = Dimens.Posters.base.width,
            height = Dimens.Posters.base.height,
            cornerRadius = Dimens.Radius.extraExtraSmall
        )

        ShimmerDarkBox(
            width = 80.dp,
            height = 25.dp,
            cornerRadius = Dimens.Radius.extraExtraSmall,
            modifier = Modifier
                .weight(1f)
                .padding(start = Dimens.Padding.base)
        )

        Icon(
            painter = painterResource(R.drawable.play_circle_60dp),
            contentDescription = Strings.Icons.playIcon,
            modifier = Modifier
                .size(Dimens.Icons.extraExtraLarge)
                .padding(end = Dimens.Padding.medium),
            tint = MaterialTheme.colorScheme.onSurface
        )
    }
}
package com.example.nexus.ui.shimmer.card.movie

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import com.example.nexus.ui.shimmer.ShimmerDarkBox
import com.example.nexus.ui.theme.Dimens
import com.example.nexus.ui.theme.FontSizes

@Composable
fun MovieTopShimmer(
    index: Int,
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.Bottom
    ) {
        Box(
            modifier = Modifier
                .width(Dimens.Box.small.width)
                .offset(x = Dimens.Padding.micro),
            contentAlignment = Alignment.BottomStart
        ) {
            Text(
                text = index.toString().substring(0,1),
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .offset(y = Dimens.Padding.sectionSmall),
                style = TextStyle(
                    color = Color.White,
                    fontSize = FontSizes.displayHuge,
                    fontWeight = FontWeight.ExtraBold,
                    fontFamily = FontFamily.Default,
                    drawStyle = Stroke(width = 2f)
                ),
                maxLines = 1
            )
        }

        ShimmerDarkBox(
            width = Dimens.Posters.top.width,
            height = Dimens.Posters.top.height,
            cornerRadius = Dimens.Radius.extraSmall
        )
    }
}
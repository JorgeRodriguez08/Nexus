package com.example.nexus.ui.shimmer.lazyrow.series

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.nexus.R
import com.example.nexus.domain.model.Episode
import com.example.nexus.ui.shimmer.ShimmerDarkBox
import com.example.nexus.ui.theme.FontSizes

@Composable
fun EpisodeDetailsRowShimmer(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = Modifier
            .padding(start = 10.dp, bottom = 34.dp, end = 10.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 14.dp),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically

        ) {
            ShimmerDarkBox(
                width = 136.dp,
                height = 76.dp,
                cornerRadius = 3.dp
            )

            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 12.dp),
                verticalArrangement = Arrangement.spacedBy(6.dp),
                horizontalAlignment = Alignment.Start
            ) {
                ShimmerDarkBox(
                    width = 172.dp,
                    height = 20.dp,
                    cornerRadius = 3.dp
                )

                ShimmerDarkBox(
                    width = 40.dp,
                    height = 20.dp,
                    cornerRadius = 3.dp
                )
            }

            Icon(
                painter = painterResource(R.drawable.play_circle_60dp),
                contentDescription = "Play Icons",
                modifier = Modifier
                    .size(49.dp)
                    .padding(end = 8.dp),
                tint = MaterialTheme.colorScheme.onSurface
            )
        }


        Column(verticalArrangement = Arrangement.spacedBy(3.dp)) {
            List(3) {
                ShimmerDarkBox(
                    modifier = Modifier.fillMaxWidth(),
                    height = 14.dp,
                    cornerRadius = 3.dp
                )
            }
        }
    }
}
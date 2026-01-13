package com.example.nexus.ui.components.section.serie

import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.nexus.R
import com.example.nexus.domain.model.Season
import com.example.nexus.domain.model.Serie

@Composable
fun SeasonRecommended(
    season: Season,
    modifier: Modifier
) {
    Row(
        modifier = Modifier.Companion.fillMaxWidth(),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.Companion.CenterVertically

    ) {
        AsyncImage(
            model = season.posterUrl,
            contentDescription = "Power Card Image",
            contentScale = ContentScale.Companion.Crop,
            modifier = Modifier.Companion
                .size(width = 136.dp, height = 76.dp)
                .clip(RoundedCornerShape(3.dp))
        )

        Text(
            text = season.name,
            fontSize = 15.sp,
            fontWeight = FontWeight.Companion.Bold,
            maxLines = 2,
            color = MaterialTheme.colorScheme.onSurface,
            modifier = Modifier.Companion
                .weight(1f)
                .padding(start = 10.dp)
        )

        Icon(
            painter = painterResource(R.drawable.play_circle_60dp),
            contentDescription = "Play Icons",
            modifier = Modifier.Companion
                .size(49.dp)
                .padding(end = 8.dp),
            tint = MaterialTheme.colorScheme.onSurface
        )
    }
}
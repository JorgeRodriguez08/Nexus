package com.example.nexus.ui.components.buttons

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import com.example.nexus.R
import com.example.nexus.ui.theme.Dimens
import com.example.nexus.ui.theme.FontSizes
import com.example.nexus.ui.theme.Strings

@Composable
fun ButtonLarge(
    label: String,
    enabled: Boolean,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = { },
        modifier = Modifier
            .fillMaxWidth()
            .height(Dimens.Buttons.large.height)
            .padding(bottom = Dimens.Padding.micro),
        enabled = enabled,
        shape = RoundedCornerShape(Dimens.Radius.extraSmall),
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.onSurface,
            contentColor = MaterialTheme.colorScheme.surface
        )
    ) {
        Row(
            modifier = Modifier,
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (label == Strings.Labels.watch) {
                Icon(
                    imageVector = Icons.Filled.PlayArrow,
                    contentDescription = label,
                    modifier = Modifier.size(Dimens.Icons.small)
                )
            } else if (label == Strings.Labels.download) {
                Icon(
                    painter = painterResource(R.drawable.download_icon),
                    contentDescription = Strings.Icons.downloadIcon,
                    modifier = Modifier.size(Dimens.Icons.small),
                    tint = MaterialTheme.colorScheme.onSurface
                )
            }

            Spacer(modifier.size(Dimens.Padding.small))

            Text(
                text = label,
                color = MaterialTheme.colorScheme.onSurface,
                fontSize = FontSizes.bodyMedium,
                fontWeight = FontWeight.Bold
            )
        }
    }
}
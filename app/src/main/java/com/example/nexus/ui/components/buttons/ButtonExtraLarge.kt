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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import com.example.nexus.R
import com.example.nexus.ui.theme.Dimens
import com.example.nexus.ui.theme.Dimens.IconSize
import com.example.nexus.ui.theme.FontSize
import com.example.nexus.ui.theme.LabelButton

@Composable
fun ButtonExtraLarge(
    label: String,
    enabled: Boolean,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = { },
        modifier = Modifier
            .fillMaxWidth()
            .height(Dimens.Buttons.extraLarge.height)
            .padding(bottom = Dimens.Padding.mini),
        enabled = false,
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
            if (label == LabelButton.WATCH) {
                Icon(
                    imageVector = Icons.Filled.PlayArrow,
                    contentDescription = label,
                    modifier = Modifier.size(IconSize.small)
                )
            } else if (label == LabelButton.DOWNLOAD) {
                Icon(
                    painter = painterResource(R.drawable.download_icon),
                    contentDescription = stringResource(R.string.download_icon),
                    modifier = Modifier.size(IconSize.small),
                    tint = MaterialTheme.colorScheme.onSurface
                )
            }

            Spacer(modifier.size(Dimens.Spacing.small))

            Text(
                text = label,
                color = MaterialTheme.colorScheme.onSurface,
                fontSize = FontSize.extraMedium,
                fontWeight = FontWeight.Bold
            )
        }
    }
}
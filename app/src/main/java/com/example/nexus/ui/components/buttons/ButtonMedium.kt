package com.example.nexus.ui.components.buttons

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import com.example.nexus.ui.theme.Dimens
import com.example.nexus.ui.theme.FontSizes

@Composable
fun ButtonMedium(
    label: String,
    onClick: () -> Unit,
    enabled: Boolean,
    imageVector: ImageVector,
    color: Color,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .width(Dimens.Buttons.medium.width)
            .height(Dimens.Buttons.medium.height),
        enabled = enabled,
        shape = RoundedCornerShape(Dimens.Radius.extraSmall),
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.onSurface,
            contentColor = MaterialTheme.colorScheme.surface,
            disabledContentColor = MaterialTheme.colorScheme.onSurface,
            disabledContainerColor = MaterialTheme.colorScheme.onSecondaryContainer.copy(alpha = Dimens.Alpha.disabled)
        ),
        contentPadding = PaddingValues(horizontal = Dimens.Padding.hairline)
    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = imageVector,
                contentDescription = label,
                modifier = Modifier.size(Dimens.Icons.regular),
                tint = color
            )

            Text(
                text = label,
                color = color,
                fontSize = FontSizes.bodySmall,
                fontWeight = FontWeight.Bold
            )
        }
    }
}
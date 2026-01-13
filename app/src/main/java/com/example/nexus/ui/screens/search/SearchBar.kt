package com.example.nexus.ui.screens.search

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import com.example.nexus.R
import com.example.nexus.ui.theme.Dimens
import com.example.nexus.ui.theme.FontSizes
import com.example.nexus.ui.theme.Strings

@Composable
fun SearchBar(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(Dimens.Box.base.height)
            .background(color = Color(0xFF202020), shape = RectangleShape)
            .padding(horizontal = Dimens.Padding.large),
        contentAlignment = Alignment.CenterStart
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                painter = painterResource(R.drawable.search_icon),
                contentDescription = Strings.Icons.searchIcon,
                modifier = Modifier.size(Dimens.Icons.small),
                tint = MaterialTheme.colorScheme.onSurface
            )

            Spacer(modifier = Modifier.width(Dimens.Padding.medium))

            BasicTextField(
                value = value,
                onValueChange = onValueChange,
                singleLine = true,
                textStyle = LocalTextStyle.current.copy(
                    fontSize = FontSizes.bodyMedium,
                    lineHeight = FontSizes.bodyLarge,
                    color = MaterialTheme.colorScheme.onSurface
                ),
                modifier = Modifier
                    .weight(1f)
                    .align(Alignment.CenterVertically)
            ) { innerTextField ->
                if (value.isEmpty()) {
                    Text(
                        text = Strings.Search.searchTextField,
                        color = MaterialTheme.colorScheme.onSurface,
                        fontSize = FontSizes.bodyMedium
                    )
                }
                innerTextField()
            }

            Icon(
                painter = painterResource(R.drawable.mic_24px),
                contentDescription = Strings.Icons.micIcon,
                modifier = Modifier.size(Dimens.Icons.small),
                tint = MaterialTheme.colorScheme.onSurface
            )
        }
    }
}
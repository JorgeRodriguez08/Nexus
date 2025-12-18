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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.nexus.R

@Composable
fun SearchBar(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(51.dp)
            .background(color = Color(0xFF202020), shape = RectangleShape)
            .padding(horizontal = 12.dp),
        contentAlignment = Alignment.CenterStart
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                painter = painterResource(R.drawable.search_icon),
                contentDescription = "Search",
                modifier = Modifier.size(23.dp),
                tint = MaterialTheme.colorScheme.onSurface
            )

            Spacer(modifier = Modifier.width(8.dp))

            BasicTextField(
                value = value,
                onValueChange = onValueChange,
                singleLine = true,
                textStyle = LocalTextStyle.current.copy(
                    fontSize = 16.sp,
                    lineHeight = 18.sp,
                    color = MaterialTheme.colorScheme.onSurface
                ),
                modifier = Modifier
                    .weight(1f)
                    .align(Alignment.CenterVertically)
            ) { innerTextField ->
                if (value.isEmpty()) {
                    Text(
                        text = "Buscar series, películas, juegos...",
                        fontSize = 16.sp,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                }
                innerTextField()
            }

            Icon(
                painter = painterResource(R.drawable.mic_24px),
                contentDescription = "Send",
                modifier = Modifier.size(23.dp),
                tint = MaterialTheme.colorScheme.onSurface
            )
        }
    }
}
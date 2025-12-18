package com.example.nexus.ui.screens.search.preview

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.nexus.R

@Composable
fun SearchBarFake(
    searchText: String = "",
    onSearchTextChanged: (String) -> Unit = {},
    modifier: Modifier = Modifier
) {
    TextField(
        value = searchText,
        onValueChange = onSearchTextChanged,
        modifier = Modifier
            .fillMaxWidth()
            .height(51.dp)
        ,
        placeholder = {
            Text(
                text = "Buscar series, películas, jue...",
                fontSize = 16.sp,
                textAlign = TextAlign.Start,
                modifier = Modifier.fillMaxWidth()
            )
        },
        leadingIcon = {
            Icon(
                painter = painterResource(R.drawable.search_icon),
                contentDescription = stringResource(R.string.search_icon),
                modifier = Modifier.size(26.dp)
            )
        },
        textStyle = LocalTextStyle.current.copy(
            fontSize = 16.sp,
            lineHeight = 18.sp
        ),
        singleLine = true,
        minLines = 1,
        colors = TextFieldDefaults.colors(
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent,
            errorIndicatorColor = Color.Transparent,
        )
    )

}
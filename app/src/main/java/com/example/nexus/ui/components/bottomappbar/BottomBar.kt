package com.example.nexus.ui.components.bottomappbar

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.example.nexus.R
import com.example.nexus.ui.navigation.Destinations
import com.example.nexus.ui.theme.Dimens
import com.example.nexus.ui.theme.FontSizes

@Composable
fun BottomBar(
    currentRoute: String,
    onNavigate: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    if (Destinations.shouldShowBottomBar(currentRoute)) {
        NavigationBar(
            modifier = modifier.height(Dimens.Bar.large)
        ) {
            val items = listOf(
                Triple(Destinations.Home.route, R.drawable.outlined_home, R.drawable.filled_home),
                Triple(Destinations.Games.route, R.drawable.outlined_game, R.drawable.filled_game),
                Triple(Destinations.NewsAndPopular.route, R.drawable.outlined_play, R.drawable.filled_play),
                Triple(Destinations.MyNexus.route, R.drawable.outlined_profile, R.drawable.filled_profile)
            )

            items.forEachIndexed { index, (route, outlinedIcon, filledIcon) ->
                NavigationBarItem(
                    selected = currentRoute == route,
                    onClick = { onNavigate(route) },
                    icon = {
                        Column(
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Icon(
                                painter = painterResource(
                                    if (currentRoute == route)
                                        filledIcon
                                    else outlinedIcon
                                ),
                                contentDescription = route,
                                modifier = Modifier.size(Dimens.Icons.medium),
                                tint =
                                    if (currentRoute == route)
                                        MaterialTheme.colorScheme.onSurface
                                    else
                                        MaterialTheme.colorScheme.onSecondaryContainer
                            )

                            Text(
                                text = route,
                                color =
                                    if (currentRoute == route)
                                        MaterialTheme.colorScheme.onSurface
                                    else
                                        MaterialTheme.colorScheme.onSecondaryContainer ,
                                fontSize = FontSizes.labelSmall
                            )
                        }
                    },
                    alwaysShowLabel = false
                )
            }
        }
    }
}
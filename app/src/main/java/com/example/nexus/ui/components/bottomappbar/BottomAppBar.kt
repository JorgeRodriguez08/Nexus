package com.example.nexus.ui.components.bottomappbar

import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.sp
import com.example.nexus.R
import com.example.nexus.ui.navigation.Dest

@Composable
fun NexusBottomAppBar(
    modifier: Modifier = Modifier,
    selectedItemIndex: Int = 0,
    onHome: () -> Unit = {},
    onGames: () -> Unit = {},
    onNewsAndPopular: () -> Unit = {},
    onMyNexus: () -> Unit = {},
) {
    NavigationBar(
        modifier = modifier
    ) {
        NavigationBarItem(
            selected = selectedItemIndex == 0,
            onClick = onHome,
            icon = {
                Icon(
                    painter = if (selectedItemIndex == 1) painterResource(R.drawable.filled_home)
                    else painterResource(R.drawable.outlined_home),
                    contentDescription = Dest.Home.route
                )
            },
            label = {
                Text(
                    text = Dest.Home.route,
                    style = MaterialTheme.typography.labelSmall,
                    fontSize = 10.sp
                )
            }
        )

        NavigationBarItem(
            selected = selectedItemIndex == 1,
            onClick = onGames,
            icon = {
                Icon(
                    painter = if (selectedItemIndex == 1) painterResource(R.drawable.filled_game)
                    else painterResource(R.drawable.outlined_game),
                    contentDescription = Dest.Games.route
                )
            },
            label = {
                Text(
                    text = Dest.Games.route,
                    style = MaterialTheme.typography.labelSmall,
                    fontSize = 10.sp
                )
            }
        )

        NavigationBarItem(
            selected = selectedItemIndex == 2,
            onClick = onNewsAndPopular,
            icon = {
                Icon(
                    painter = if (selectedItemIndex == 1) painterResource(R.drawable.filled_play)
                    else painterResource(R.drawable.outlined_play),
                    contentDescription = Dest.NewsAndPopular.route
                )
            },
            label = {
                Text(
                    text = Dest.NewsAndPopular.route,
                    maxLines = 1,
                    style = MaterialTheme.typography.labelSmall,
                    fontSize = 10.sp
                )
            }
        )

        NavigationBarItem(
            selected = selectedItemIndex == 2,
            onClick = onMyNexus,
            icon = {
                Icon(
                    painter = if (selectedItemIndex == 0) painterResource(R.drawable.filled_profile)
                    else painterResource(R.drawable.outlined_profile),
                    contentDescription = Dest.MyNexus.route
                )
            },
            label = {
                Text(
                    text = Dest.MyNexus.route,
                    style = MaterialTheme.typography.labelSmall,
                    fontSize = 10.sp
                )
            }
        )
    }
}
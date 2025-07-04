    package com.example.nexus.ui.composables.bottomappbar

    import android.content.res.Configuration
    import androidx.compose.material.icons.Icons
    import androidx.compose.material.icons.filled.AccountBox
    import androidx.compose.material.icons.filled.Favorite
    import androidx.compose.material.icons.filled.PlayArrow
    import androidx.compose.material3.ExperimentalMaterial3Api
    import androidx.compose.material3.Icon
    import androidx.compose.material3.MaterialTheme
    import androidx.compose.material3.NavigationBar
    import androidx.compose.material3.NavigationBarItem
    import androidx.compose.material3.Text
    import androidx.compose.runtime.Composable
    import androidx.compose.ui.Modifier
    import androidx.compose.ui.res.painterResource
    import androidx.compose.ui.text.style.TextOverflow
    import androidx.compose.ui.tooling.preview.Preview
    import androidx.compose.ui.unit.sp
    import com.example.nexus.R
    import com.example.nexus.ui.theme.NexusTheme


    @Composable
    fun NexusBottomAppBar(
        modifier: Modifier = Modifier,
        selectedItemIndex: Int = 0,
        onHome: () -> Unit = {},
        onNews: () -> Unit = {},
        onPopular: () -> Unit = {},
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
                        contentDescription = "Inicio"
                    )
                },
                label = { Text(text = "Inicio", style = MaterialTheme.typography.labelSmall, fontSize = 10.sp) }
            )

            NavigationBarItem(
                selected = selectedItemIndex == 1,
                onClick = onNews,
                icon = {
                    Icon(
                        painter = if (selectedItemIndex == 1) painterResource(R.drawable.filled_game)
                            else painterResource(R.drawable.outlined_game),
                        contentDescription = "Juegos"
                    )
                },
                label = { Text(text = "Juegos", style = MaterialTheme.typography.labelSmall, fontSize = 10.sp) }
            )

            NavigationBarItem(
                selected = selectedItemIndex == 2,
                onClick = onPopular,
                icon = {
                    Icon(
                        painter = if (selectedItemIndex == 1) painterResource(R.drawable.filled_play)
                            else painterResource(R.drawable.outlined_play),
                        contentDescription = "Nuevo y popular"
                    )
                },
                label = { Text(text = "Nuevo y Popular", maxLines = 1, style = MaterialTheme.typography.labelSmall, fontSize = 10.sp)}
            )

            NavigationBarItem(
                selected = selectedItemIndex == 2,
                onClick = onMyNexus,
                icon = {
                    Icon(
                        painter = if (selectedItemIndex == 0) painterResource(R.drawable.filled_profile)
                            else painterResource(R.drawable.outlined_profile),
                        contentDescription = "Mi Nexus"
                    )
                },
                label = { Text(text = "Mi Nexus", style = MaterialTheme.typography.labelSmall, fontSize = 10.sp) }
            )

        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES )
    @Composable
    fun PreviewBottomAppBar() {
        NexusTheme{
            NexusBottomAppBar()
        }
    }
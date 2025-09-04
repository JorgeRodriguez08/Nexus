package com.example.nexus.ui.components.topappbar

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.nexus.R
import com.example.nexus.ui.components.filterrowbar.FilterRowBar
import com.example.nexus.ui.navigation.Dest

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NexusTopAppBar(
    modifier: Modifier = Modifier,
    currentRoute: String,
    canNavigateBack: Boolean = false,
    onSearchClick: () -> Unit,
    onBackClick: () -> Unit,
    onDownloadClick: () -> Unit,
    onFilterSelected: (String) -> Unit
) {
    Column(
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        TopAppBar(
            title = {
                when (currentRoute) {
                    Dest.Home.route -> Text(text = Dest.Home.route, fontSize = 22.sp)
                    Dest.Games.route -> Text(text = Dest.Games.route, fontSize = 22.sp)
                    Dest.NewsAndPopular.route -> Text(text = Dest.NewsAndPopular.route, fontSize = 22.sp)
                    Dest.MyNexus.route -> Text(text = Dest.MyNexus.route, fontSize = 22.sp)
                    Dest.Series.route -> Text(text = Dest.Series.route, fontSize = 22.sp)
                    Dest.Movies.route -> Text(text = Dest.Movies.route, fontSize = 22.sp)
                    Dest.Categories.route -> Text(text = Dest.Categories.route, fontSize = 22.sp)
                }
            },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = MaterialTheme.colorScheme.background,
                titleContentColor = MaterialTheme.colorScheme.onBackground
            ),
            navigationIcon = {
                when (currentRoute) {
                    Dest.Series.route, Dest.Movies.route, Dest.Categories.route -> {
                        IconButton(onClick = onBackClick) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                contentDescription = stringResource(R.string.back_icon)
                            )
                        }
                    }
                    Dest.Home.route -> {
                        Image(
                            painter = painterResource(R.drawable.icons8_netflix_96),
                            contentDescription = stringResource(R.string.nexus_icon),
                            modifier = Modifier
                                .size(43.dp)
                        )
                    }
                }
            },
            actions = {

                IconButton(onClick = {  }) {
                    Icon(
                        painter = painterResource(R.drawable.cast_24dp),
                        contentDescription = Dest.MyNexus.route,
                        modifier = Modifier.size(28.dp)
                    )
                }

                IconButton(onClick = onDownloadClick) {
                    Icon(
                        painter = painterResource(R.drawable.vertical_align_bottom),
                        contentDescription = Dest.MyNexus.route,
                        modifier = Modifier.size(28.dp)
                    )
                }

                IconButton(onClick = onSearchClick) {
                    Icon(
                        painter = painterResource(R.drawable.magnifying_glass),
                        contentDescription = Dest.Search.route,
                        modifier = Modifier.size(28.dp)
                    )
                }
            },
            modifier = modifier
        )

        FilterRowBar(
            selectedOption = currentRoute,
            onOptionSelected = onFilterSelected
        )
    }
}

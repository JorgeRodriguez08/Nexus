package com.example.nexus.ui.screens.newsPopular

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.nexus.domain.model.MovieDetails
import com.example.nexus.ui.theme.Dimens
import com.example.nexus.ui.theme.FontSizes
import com.example.nexus.ui.theme.Strings

@Composable
fun NewsMovieCard(
    movieDetails: MovieDetails,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = Modifier
            .width(Dimens.Posters.extraLarge.width)
            .wrapContentHeight(),
        shape = RoundedCornerShape( Dimens.Padding.large),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.background
        ),
        border = BorderStroke(
            width = Dimens.Padding.hairline,
            color = MaterialTheme.colorScheme.onSecondaryContainer.copy(alpha = Dimens.Alpha.regular)
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = Dimens.Padding.extraLarge),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box {
                AsyncImage(
                    model = movieDetails.movie.backdropUrl,
                    contentDescription = movieDetails.movie.title,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(Dimens.Posters.base.height)
                        .clip(
                            RoundedCornerShape(
                                topStart = Dimens.Radius.large,
                                topEnd = Dimens.Radius.large
                            )
                        ),
                    contentScale = ContentScale.Crop
                )

                Card(
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .padding(top = Dimens.Padding.medium, end = Dimens.Padding.medium)
                        .width(Dimens.Posters.extraExtraSmall.width)
                        .height(Dimens.Posters.extraExtraSmall.height),
                    shape = RoundedCornerShape(Dimens.Radius.micro),
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.background
                    )
                ) {}

                Text(
                    text =
                        if (movieDetails.movie.adult)
                            Strings.Badges.adults
                        else
                            Strings.Badges.kids,
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .padding(top = Dimens.Padding.extraSmall, end = Dimens.Padding.large),
                    color = MaterialTheme.colorScheme.onSurface,
                    fontSize = FontSizes.labelMedium,
                    fontWeight = FontWeight.ExtraBold,
                    maxLines = 1
                )
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = Dimens.Padding.large, vertical = Dimens.Padding.small),
                verticalArrangement = Arrangement.spacedBy(Dimens.Padding.medium),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                if (movieDetails.image.fileUrl.isNotEmpty()) {
                    AsyncImage(
                        model = movieDetails.image.fileUrl,
                        contentDescription = Strings.Labels.movieLogo,
                        modifier = Modifier.height(Dimens.Posters.extraSmall.height),
                        contentScale = ContentScale.Fit
                    )
                } else {
                    Text(
                        text = movieDetails.movie.title,
                        color = MaterialTheme.colorScheme.onSurface,
                        fontSize = FontSizes.titleSmall,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                        maxLines = 2
                    )
                }
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = Dimens.Padding.base, vertical = Dimens.Padding.small),
                verticalArrangement = Arrangement.spacedBy(Dimens.Padding.medium),
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = Strings.Labels.release + movieDetails.movie.releaseDate,
                    color = MaterialTheme.colorScheme.onSurface,
                    fontSize = FontSizes.bodySmall,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = movieDetails.movie.overview,
                    color = MaterialTheme.colorScheme.onSurface,
                    fontSize = FontSizes.labelMedium,
                    fontWeight = FontWeight.Normal,
                    lineHeight = FontSizes.bodyMedium,
                    maxLines = 5
                )

                Spacer(modifier = Modifier.height(Dimens.Padding.medium))

                Button(
                    onClick = {},
                    modifier = Modifier
                        .width(Dimens.Buttons.regular.width)
                        .height(Dimens.Buttons.regular.height),
                    shape = RoundedCornerShape(Dimens.Radius.extraSmall),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.onSurface,
                        contentColor = MaterialTheme.colorScheme.surface
                    ),
                    contentPadding = PaddingValues(
                        horizontal = Dimens.Padding.hairline,
                        vertical = Dimens.Padding.hairline
                    )
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = Icons.Outlined.Notifications,
                            contentDescription = Strings.Icons.notificationsIcon,
                            modifier = Modifier.size(Dimens.Icons.medium)
                        )

                        Spacer(Modifier.width(Dimens.Padding.small))

                        Text(
                            text = Strings.Labels.notify,
                            fontSize = FontSizes.bodyMedium,
                            fontWeight = FontWeight.Bold,
                            maxLines = 1
                        )
                    }
                }
            }
        }
    }
}
package com.example.nexus.ui.screens.newsPopular

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.nexus.ui.shimmer.ShimmerDarkBox
import com.example.nexus.ui.theme.Dimens
import com.example.nexus.ui.theme.FontSizes
import com.example.nexus.ui.theme.Strings

@Composable
fun NewsMovieCardShimmer(
    modifier: Modifier = Modifier
) {
    Card(
        modifier = Modifier
            .width(Dimens.Posters.extraExtraLarge.width)
            .height(Dimens.Posters.extraLarge.height),
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
                .fillMaxWidth()
                .padding(bottom = Dimens.Padding.extraLarge),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ShimmerDarkBox(
                width = Dimens.Posters.extraExtraLarge.width,
                height = Dimens.Posters.large.height,
                cornerRadius = Dimens.Radius.large,
                semiRadius = true
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = Dimens.Padding.large, vertical = Dimens.Padding.small),
                verticalArrangement = Arrangement.spacedBy(Dimens.Padding.medium),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                ShimmerDarkBox(
                    width = Dimens.Posters.large.width,
                    height = Dimens.Posters.extraExtraSmall.height,
                    cornerRadius = Dimens.Radius.small
                )
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp)
                    .padding(horizontal = Dimens.Padding.base, vertical = Dimens.Padding.small),
                verticalArrangement = Arrangement.spacedBy(Dimens.Padding.medium),
                horizontalAlignment = Alignment.Start
            ) {
                Box(contentAlignment = Alignment.CenterStart) {

                    ShimmerDarkBox(
                        width = 175.dp,
                        height = 25.dp,
                        cornerRadius = Dimens.Radius.extraExtraSmall
                    )




                }

                Box(contentAlignment = Alignment.CenterStart) {
                    Column (verticalArrangement = Arrangement.spacedBy(3.dp)) {
                        List(5){
                            ShimmerDarkBox(
                                width = 370.dp,
                                height = 15.dp,
                                cornerRadius = Dimens.Radius.extraExtraSmall
                            )
                        }

                    }

                }
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = Dimens.Padding.base)
            ) {
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
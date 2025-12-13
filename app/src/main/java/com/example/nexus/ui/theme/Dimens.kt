package com.example.nexus.ui.theme

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

object Dimens {
    object Padding {
        val hairline = 1.dp
        val micro = 2.dp
        val extraSmall = 4.dp
        val small = 6.dp
        val medium = 8.dp
        val base = 10.dp
        val large = 12.dp
        val extraLarge = 14.dp
        val extraExtraLarge = 16.dp
        val gigaLarge = 18.dp
        val sectionSmall = 20.dp
        val sectionMedium = 24.dp
        val sectionLarge = 32.dp
        val hero = 50.dp
    }

    object Radius {
        val micro = 2.dp
        val extraSmall = 4.dp
        val base = 10.dp
        val large = 12.dp
        val gigaLarge = 18.dp
    }

    object Border {
        val thin = 0.5.dp
        val hairline = 1.dp
    }

    object Alpha {
        const val disabled = 0.45f
        const val medium = 0.60f
    }

    data class Size(
        val width: Dp,
        val height: Dp
    )

    object Poster {
        val small = Size(116.dp, 162.dp)
        val large = Size(360.dp, 496.dp)
    }

    object Button {
        val regular = Size(158.dp, 38.dp)
        val large = Size(158.dp, 50.dp)
    }

    object Icon {
        val small = 18.dp
        val medium = 26.dp
        val regular = 28.dp
        val large = 32.dp
        val extraLarge = 42.dp
    }

    object Filter {
        val small = Size(40.dp, 40.dp)
        val medium = Size(88.dp, 48.dp)
        val large = Size(110.dp, 48.dp)
    }

    object Bar {
        val large = 110.dp
    }

    object AspectRatio {
        const val poster = 1.7f
    }
}
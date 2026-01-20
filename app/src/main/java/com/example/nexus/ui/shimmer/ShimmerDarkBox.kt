package com.example.nexus.ui.shimmer

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun ShimmerDarkBox(
    width: Dp = 0.dp,
    height: Dp = 0.dp,
    cornerRadius: Dp = 0.dp,
    semiRadius: Boolean = false,
    shimmerWidth: Float = 300f,
    animationDuration: Int = 1300,
    modifier: Modifier = Modifier
) {

    // Colores oscuros estilo Netflix
    val shimmerColors = listOf(
        Color(0xFF121213), // base oscuro
        Color(0xFF2C2C2F), // highlight
        Color(0xFF121213)  // base oscuro
    )

    // Animación infinita
    val transition = rememberInfiniteTransition()
    val translate = transition.animateFloat(
        initialValue = -shimmerWidth,
        targetValue = shimmerWidth * 4,   // largo para cubrir diagonal
        animationSpec = infiniteRepeatable(
            animation = tween(animationDuration, easing = LinearEasing)
        )
    )

    // Brush diagonal a 45 grados
    val brush = Brush.linearGradient(
        colors = shimmerColors,
        start = Offset(
            x = translate.value,
            y = 0f
        ),
        end = Offset(
            x = translate.value - shimmerWidth,
            y = shimmerWidth   // crea el ángulo diagonal
        )
    )

    Box(
        modifier = modifier
            .background(brush,
                if (semiRadius)
                    RoundedCornerShape(
                        topStart = cornerRadius,
                        topEnd = cornerRadius
                    ) else
                    RoundedCornerShape(cornerRadius)
            )
            .width(width)
            .height(height)
    )
}
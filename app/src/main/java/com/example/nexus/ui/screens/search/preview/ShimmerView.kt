package com.example.nexus.ui.screens.search.preview

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun ShimmerDemoCardPreview() {
    ShimmerDemoCard(
        modifier = Modifier
    )
}

@Preview
@Composable
fun ShimmerDemoDarkPreview() {
    Row {
        repeat(4) {
            Column {
                DarkDiagonalShimmerItem(
                    modifier = Modifier.height(50.dp).width(50.dp)
                )
                Spacer(modifier = Modifier.height(2.dp))
                DarkDiagonalShimmerItem(
                    modifier = Modifier.height(12.dp).width(80.dp),
                    cornerRadius = 2.dp
                )
            }
        }
    }
}

@Composable
fun ShimmerDemoCard(
    modifier: Modifier = Modifier,
    cornerRadius: Dp = 8.dp,
    shimmerWidth: Float = 200f,     // ancho de la franja brillante en px
    animationDuration: Int = 1000   // ms
) {
    val shimmerColors = listOf(
        Color.LightGray.copy(alpha = 0.6f),
        Color.LightGray.copy(alpha = 0.3f),
        Color.LightGray.copy(alpha = 0.6f)
    )

    // animación infinita
    val transition = rememberInfiniteTransition()
    val translateAnim = transition.animateFloat(
        initialValue = -shimmerWidth,
        targetValue = 1000f, // valor grande para que cruce todo el componente
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = animationDuration, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        )
    )

    val brush = Brush.linearGradient(
        colors = shimmerColors,
        start = Offset(translateAnim.value, 0f),
        end = Offset(translateAnim.value + shimmerWidth, 0f)
    )

    Box(
        modifier = modifier
            .background(brush = brush, shape = RoundedCornerShape(cornerRadius))
            .height(120.dp)
            .fillMaxWidth()
    )
}

@Composable
fun DarkShimmerItem(
    modifier: Modifier = Modifier,
    cornerRadius: Dp = 10.dp,
    shimmerWidth: Float = 250f,
    animationDuration: Int = 1200
) {
    // Colores estilo Netflix / Flow: grises oscuros con un highlight suave
    val shimmerColors = listOf(
        Color(0xFF1C1C1E), // gris oscuro base
        Color(0xFF2A2A2D), // highlight suave
        Color(0xFF1C1C1E)  // gris oscuro base
    )

    // Animación infinita
    val transition = rememberInfiniteTransition()
    val translateAnim = transition.animateFloat(
        initialValue = -shimmerWidth,
        targetValue = 1000f,
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = animationDuration,
                easing = LinearEasing
            ),
            repeatMode = RepeatMode.Restart
        )
    )

    val brush = Brush.linearGradient(
        colors = shimmerColors,
        start = Offset(translateAnim.value, 0f),
        end = Offset(translateAnim.value + shimmerWidth, 0f)
    )

    Box(
        modifier = modifier
            .background(
                brush = brush,
                shape = RoundedCornerShape(cornerRadius)
            )
            .height(160.dp)   // típico de card de Netflix
            .fillMaxWidth()
    )
}

@Composable
fun DarkDiagonalShimmerItem(
    modifier: Modifier = Modifier,
    cornerRadius: Dp = 10.dp,
    shimmerWidth: Float = 300f,
    animationDuration: Int = 1300
) {
    // Colores oscuros estilo Netflix
    val shimmerColors = listOf(
        Color(0xFF1A1A1C), // base oscuro
        Color(0xFF2C2C2F), // highlight
        Color(0xFF1A1A1C)  // base oscuro
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
            .background(brush, RoundedCornerShape(cornerRadius))
            .height(160.dp)
            .fillMaxWidth()
    )
}
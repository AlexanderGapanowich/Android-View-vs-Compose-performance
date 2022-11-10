package com.example.compose.ui

import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import com.example.compose.R

@Composable
fun FourthScreen() {
    LazyVerticalGrid(columns = GridCells.Fixed(8)){
        items(1000) {
            Star()
        }
    }
}

@Composable
fun Star() {
    val infiniteTransition = rememberInfiniteTransition()
    val color = remember {getRandomHexColor()}

    // Creates a child animation of float type as a part of the [InfiniteTransition].
    val alpha by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(
            // Infinitely repeating a 1000ms tween animation using default easing curve.
            animation = tween(1000),
            // After each iteration of the animation (i.e. every 1000ms), the animation will
            // start again from the [initialValue] defined above.
            // This is the default [RepeatMode]. See [RepeatMode.Reverse] below for an
            // alternative.
            repeatMode = RepeatMode.Reverse
        )
    )

    Image(painterResource(id = R.drawable.baseline_star_24), contentDescription = null,
        modifier = Modifier.alpha(alpha), colorFilter = ColorFilter.tint(
        Color.parse(color)))
}
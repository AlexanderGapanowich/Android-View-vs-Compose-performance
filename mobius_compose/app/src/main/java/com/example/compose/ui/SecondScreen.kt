package com.example.compose.ui

import android.app.Activity
import android.util.Log
import androidx.compose.animation.core.*
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.window.layout.WindowMetricsCalculator
import com.example.compose.R
import kotlinx.coroutines.coroutineScope
import kotlin.coroutines.coroutineContext
import kotlin.random.Random

@Composable
fun SecondScreen() {
    Box(modifier = Modifier.fillMaxSize()) {
        val activity = LocalContext.current as Activity
        val windowMetrics = remember{ WindowMetricsCalculator.getOrCreate().computeCurrentWindowMetrics(
            activity)}
        val width = remember {windowMetrics.bounds.width()}
        val height = remember {windowMetrics.bounds.height()}
        repeat(1000) {
            val coordinates = getRandomCoordinates(width,height)
            val x by animateIntAsState(targetValue = coordinates.first, animationSpec = tween(
                durationMillis = 2000
            ))
            val y by animateIntAsState(targetValue = coordinates.second, animationSpec = tween(
                durationMillis = 2000
            ))
            Box(
                modifier = Modifier.offset{
                    IntOffset(x,y)
                }.size(120.dp).clip(CircleShape).background(Color.Blue)
            )
        }
    }
}

fun getRandomCoordinates(width:Int, height: Int): Pair<Int, Int> {
    return Pair(Random.nextInt(width), Random.nextInt(height))
}
package com.example.compose.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp

@Composable
fun ThirdScreen() {
    LazyColumn() {
        items(500) {
            VerticalElement()
        }
    }
}

@Composable
fun VerticalElement() {
    val color = remember{getRandomHexColor()}
    Box(modifier = Modifier
        .fillMaxWidth()
        .background(Color.parse(color)), contentAlignment = Alignment.Center) {
        Text(text = color, fontSize = 24.sp, color = Color.Black)
    }
}

fun getRandomHexColor(): String {
    val colors = listOf<String>("#FF0000","#0000FF", "#FFFF00", "#00FF00")
    return colors.random()
}

fun Color.Companion.parse(colorString: String): Color =
    Color(color = android.graphics.Color.parseColor(colorString))
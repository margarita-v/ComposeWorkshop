package com.example.composeworkshop.ui.main.core

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.valentinilk.shimmer.shimmer

@Composable
fun LoadStub(
    modifier: Modifier,
    color: Color = Color.Gray,
    shapeSize: Dp = 16.dp,
    content: @Composable () -> Unit = {}
) {
    Card(
        modifier = modifier
            .shimmer(),
        shape = RoundedCornerShape(shapeSize),
        backgroundColor = color
    ) { content() }
}
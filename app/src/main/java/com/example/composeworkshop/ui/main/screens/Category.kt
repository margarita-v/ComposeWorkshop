package com.example.composeworkshop.ui.main.screens

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import ru.surfstudio.compose.routing.NavScreenWithArgument

object CategoryNav {
    val CategoryNavScreen = object : NavScreenWithArgument {
        override val argument0: String = "name"
        override val routeWithArgument: String = "CategoryNavScreen/{$argument0}"
    }
}

@Composable
fun Category(name: String) {
    Text(name)
}
package com.example.composeworkshop.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val DarkColorPalette = darkColors(
    primary = Turquoise,
    primaryVariant = TurquoiseLight,
    secondary = Red,
    onSecondary = SteelGray300
)

private val LightColorPalette = lightColors(
    primary = Turquoise,
    primaryVariant = TurquoiseLight,
    secondary = Red,
    onSecondary = SteelGray300
)

@Composable
fun ComposeWorkshopTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}
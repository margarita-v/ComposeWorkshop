package com.example.composeworkshop.ui.main.navigation

import ru.surfstudio.compose.routing.NavigationRouteArgument1

/** Navigation routes for screens which doesn't keep bottom nav bar (separate ones) */
object ScreenNav {

    object FullCategoryNavScreen : NavigationRouteArgument1 {
        override val argument0: String = "name"
        override val route: String = "FullCategoryNavScreen/{$argument0}"
    }
}
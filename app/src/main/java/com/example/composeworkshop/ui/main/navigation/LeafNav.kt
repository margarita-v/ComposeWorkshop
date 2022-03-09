package com.example.composeworkshop.ui.main.navigation

import ru.surfstudio.compose.routing.NavigationRouteArgument1

/**
 * Leaf for each nested graph, the root must be defined for each navigation route.
 * Using this approach, a one screen could be reused between different nested tabs
 */
object LeafNav {

    object CategoryNavScreen : NavigationRouteArgument1 {
        override val argument0: String = "name"
        override val route: String = "CategoryNavScreen/{$argument0}"
    }

    object StackNavScreen : NavigationRouteArgument1 {
        override val argument0: String = "title"
        override val route: String = "StackNavScreen/{$argument0}"
    }
}
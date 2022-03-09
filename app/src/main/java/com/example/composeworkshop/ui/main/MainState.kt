package com.example.composeworkshop.ui.main

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState

/**
 * Responsible for holding state related to [MainScreen] and containing UI-related logic.
 */
@Stable
class MainState(private val navController: NavHostController) {

    private val bottomBarRoutes = MainTab.values().map { it.route }

    // Reading this attribute will cause recompositions when the bottom bar needs shown, or not.
    // Not all routes need to show the bottom bar.
    val shouldShowBottomBar: Boolean
        @Composable get() {
            val currentRoute = navController
                .currentBackStackEntryAsState().value?.destination?.route.orEmpty()
            return bottomBarRoutes.any { currentRoute.startsWith(it) }
        }
}

@Composable
fun rememberMainState(
    navController: NavHostController
) = remember(navController) { MainState(navController) }
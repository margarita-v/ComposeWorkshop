package com.example.composeworkshop.ui.main.tabs.home

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import coil.annotation.ExperimentalCoilApi
import com.example.composeworkshop.ui.main.navigation.LeafNav
import com.example.composeworkshop.ui.main.MainTab
import com.example.composeworkshop.ui.main.screens.navigateToCategory

@ExperimentalCoilApi
fun NavGraphBuilder.homeNavGraph(navController: NavController, tab: MainTab) {
    navigation(
        route = tab.name,
        startDestination = tab.route,
    ) {
        composable(tab.route) {
            HomeScreen(
                onCategoryClick = { categoryName ->
                    navController.navigate(
                        LeafNav.CategoryNavScreen.routeWithRootAndArguments(
                            root = tab.route,
                            argument0 = categoryName
                        )
                    )
                }
            )
        }
        with(LeafNav.CategoryNavScreen) {
            navigateToCategory(
                route = configureRoute(root = tab.route),
                argument = argument0
            )
        }
    }
}
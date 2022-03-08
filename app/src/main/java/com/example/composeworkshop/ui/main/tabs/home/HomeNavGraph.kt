package com.example.composeworkshop.ui.main.tabs.home

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import coil.annotation.ExperimentalCoilApi
import com.example.composeworkshop.ui.main.LeafNav
import com.example.composeworkshop.ui.main.MainTab

@ExperimentalCoilApi
fun NavGraphBuilder.homeNavGraph(navController: NavController, tab: MainTab) {
    navigation(
        route = tab.route,
        startDestination = tab.name,
    ) {
        composable(tab.name) {
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
            composable(configureRoute(root = tab.route)) { backStackEntry ->
                backStackEntry.arguments?.let { bundle ->
                    com.example.composeworkshop.ui.main.screens.Category(
                        name = bundle.getString(argument0)!!
                    )
                }
            }
        }
    }
}
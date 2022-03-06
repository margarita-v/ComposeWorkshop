package com.example.composeworkshop.ui.main.tabs.home

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import coil.annotation.ExperimentalCoilApi
import com.example.composeworkshop.ui.main.MainTab
import com.example.composeworkshop.ui.main.screens.CategoryNav

@ExperimentalCoilApi
fun NavGraphBuilder.homeNavGraph(navController: NavController) {
    composable(MainTab.Home.route) {
        HomeScreen(
            onCategoryClick = {
                navController.navigate(CategoryNav.CategoryNavScreen.getRoute(it))
            }
        )
    }
    with(CategoryNav.CategoryNavScreen) {
        composable(routeWithArgument) { backStackEntry ->
            backStackEntry.arguments?.let { bundle ->
                com.example.composeworkshop.ui.main.screens.Category(
                    name = bundle.getString(argument0)!!
                )
            }
        }
    }
}
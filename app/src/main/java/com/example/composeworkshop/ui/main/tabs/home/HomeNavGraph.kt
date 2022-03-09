package com.example.composeworkshop.ui.main.tabs.home

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import coil.annotation.ExperimentalCoilApi
import com.example.composeworkshop.ui.main.MainTab
import com.example.composeworkshop.ui.main.navigation.LeafNav
import com.example.composeworkshop.ui.main.navigation.TabNav
import com.example.composeworkshop.ui.main.screens.Stack
import com.example.composeworkshop.ui.main.screens.navigateToCategory
import kotlin.random.Random

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
                },
                openNextScreen = {
                    navController.navigate(
                        LeafNav.StackNavScreen.routeWithRootAndArguments(
                            root = tab.route,
                            argument0 = "Start stack"
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
        with(LeafNav.StackNavScreen) {
            composable(configureRoute(root = tab.route)) { backStackEntry ->
                backStackEntry.arguments?.let { bundle ->
                    Stack(
                        title = bundle.getString(argument0)!!,
                        openScreenClick = {
                            navController.navigate(
                                LeafNav.StackNavScreen.routeWithRootAndArguments(
                                    root = tab.route,
                                    argument0 = "Stack ${Random.nextInt()}"
                                )
                            )
                        },
                        clearStackClick = {
                            navController.popBackStack(TabNav.HomeNavScreen.route, false)
                        }
                    )
                }
            }
        }
    }
}
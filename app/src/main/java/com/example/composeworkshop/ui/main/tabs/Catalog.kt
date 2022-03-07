package com.example.composeworkshop.ui.main.tabs

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.example.composeworkshop.ui.main.Greeting
import com.example.composeworkshop.ui.main.MainTab

fun NavGraphBuilder.catalogNavGraph(navController: NavController, tab: MainTab) {
    navigation(
        route = tab.route,
        startDestination = tab.name,
    ) {
        composable(tab.name) {
            CatalogScreen()
        }
    }
}

@Composable
fun CatalogScreen() {
    Greeting("Catalog")
}
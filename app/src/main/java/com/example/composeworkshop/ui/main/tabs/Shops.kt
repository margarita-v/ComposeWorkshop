package com.example.composeworkshop.ui.main.tabs

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.example.composeworkshop.ui.main.Greeting
import com.example.composeworkshop.ui.main.MainTab

fun NavGraphBuilder.shopsNavGraph(navController: NavController, tab: MainTab) {
    navigation(
        route = tab.name,
        startDestination = tab.route,
    ) {
        composable(tab.route) {
            ShopsScreen()
        }
    }
}

@Composable
fun ShopsScreen() {
    Greeting("Shops")
}
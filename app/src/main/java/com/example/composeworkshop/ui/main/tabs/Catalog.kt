package com.example.composeworkshop.ui.main.tabs

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.composeworkshop.ui.main.Greeting
import com.example.composeworkshop.ui.main.MainTab

fun NavGraphBuilder.catalogNavGraph(navController: NavController) {
    composable(MainTab.Catalog.route) {
        CatalogScreen()
    }
}

@Composable
fun CatalogScreen() {
    Greeting("Catalog")
}
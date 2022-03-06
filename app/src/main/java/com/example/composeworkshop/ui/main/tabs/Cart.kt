package com.example.composeworkshop.ui.main.tabs

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.composeworkshop.ui.main.Greeting
import com.example.composeworkshop.ui.main.MainTab

fun NavGraphBuilder.cartNavGraph(navController: NavController) {
    composable(MainTab.Cart.route) {
        CartScreen()
    }
}

@Composable
fun CartScreen() {
    Greeting("Cart")
}
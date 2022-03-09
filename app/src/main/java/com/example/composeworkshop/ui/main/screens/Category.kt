package com.example.composeworkshop.ui.main.screens

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

fun NavGraphBuilder.navigateToCategory(route: String, argument: String) {
    composable(route) { backStackEntry ->
        backStackEntry.arguments?.let { bundle ->
            Category(
                name = bundle.getString(argument)!!
            )
        }
    }
}

@Composable
fun Category(name: String) {
    Text(name)
}
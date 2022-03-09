package com.example.composeworkshop.ui.main.tabs

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.example.composeworkshop.ui.main.MainTab
import com.example.composeworkshop.ui.main.navigation.ScreenNav

fun NavGraphBuilder.catalogNavGraph(navController: NavController, tab: MainTab) {
    navigation(
        route = tab.name,
        startDestination = tab.route,
    ) {
        composable(tab.route) {
            CatalogScreen(
                openCategoryClicked = {
                    navController.navigate(
                        ScreenNav.FullCategoryNavScreen.routeWithArguments("Sample")
                    )
                }
            )
        }
    }
}

@Composable
fun CatalogScreen(openCategoryClicked: () -> Unit) {
    Column {
        Button(onClick = { openCategoryClicked() }) {
            Text(textAlign = TextAlign.Center, text = "Open full screen category")
        }
    }
}
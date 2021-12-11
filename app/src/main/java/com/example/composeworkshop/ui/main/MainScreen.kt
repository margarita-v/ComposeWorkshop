package com.example.composeworkshop.ui.main

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.composeworkshop.ui.main.tabs.*
import com.example.composeworkshop.ui.theme.Typography
import com.google.accompanist.insets.navigationBarsHeight

@Composable
fun BottomNavigationBar(navController: NavController) {
    val items = MainTab.values()
    BottomNavigation(
        modifier = Modifier.navigationBarsHeight(56.dp),
        contentColor = MaterialTheme.colors.background,
        backgroundColor = MaterialTheme.colors.background
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        items.forEach { item ->
            BottomNavigationItem(
                icon = {
                    Icon(
                        modifier = Modifier
                            .size(24.dp)
                            .padding(2.dp),
                        painter = painterResource(id = item.iconResId),
                        contentDescription = stringResource(id = item.titleResId)
                    )
                },
                label = {
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = stringResource(id = item.titleResId),
                        fontFamily = Typography.caption.fontFamily,
                        maxLines = 1,
                    )
                },
                selectedContentColor = MaterialTheme.colors.secondary,
                unselectedContentColor = MaterialTheme.colors.onSecondary,
                alwaysShowLabel = true,
                selected = currentRoute == item.route,
                onClick = {
                    navController.navigate(item.route) {
                        // Pop up to the start destination of the graph to
                        // avoid building up a large stack of destinations
                        // on the back stack as users select items
                        navController.graph.startDestinationRoute?.let { route ->
                            popUpTo(route) {
                                saveState = true
                            }
                        }
                        // Avoid multiple copies of the same destination when
                        // reselecting the same item
                        launchSingleTop = true
                        // Restore state when reselecting a previously selected item
                        restoreState = true
                    }
                }
            )
        }
    }
}

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController, startDestination = MainTab.Home.route) {
        MainTab.values().forEach { tab ->
            composable(tab.route) {
                when (tab) {
                    MainTab.Home -> HomeScreen()
                    MainTab.Catalog -> CatalogScreen()
                    MainTab.Cart -> CartScreen()
                    MainTab.Shops -> ShopsScreen()
                    MainTab.Profile -> ProfileScreen()
                }
            }
        }
    }
}


@Composable
fun Greeting(title: String) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(textAlign = TextAlign.Center, text = title)
    }
}

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = { BottomNavigationBar(navController) }
    ) {
        Navigation(navController)
    }
}
package com.example.composeworkshop.ui.main

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.LifecycleEventObserver
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import coil.annotation.ExperimentalCoilApi
import com.example.composeworkshop.ui.main.navigation.ScreenNav
import com.example.composeworkshop.ui.main.screens.navigateToCategory
import com.example.composeworkshop.ui.main.tabs.cartNavGraph
import com.example.composeworkshop.ui.main.tabs.catalogNavGraph
import com.example.composeworkshop.ui.main.tabs.home.homeNavGraph
import com.example.composeworkshop.ui.main.tabs.profileNavGraph
import com.example.composeworkshop.ui.main.tabs.shopsNavGraph
import com.example.composeworkshop.ui.theme.Typography
import com.google.accompanist.insets.navigationBarsHeight
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.flow.FlowCollector

@Composable
fun Greeting(title: String) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(textAlign = TextAlign.Center, text = title)
    }
}

@InternalCoroutinesApi
@ExperimentalCoilApi
@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val mainState = rememberMainState(navController = navController)
    ScreenLogging(navController = navController)
    Scaffold(
        bottomBar = {
            if (mainState.shouldShowBottomBar) {
                BottomNavigationBar(navController)
            }
        }
    ) {
        Navigation(navController)
    }
}

/** Log current visible screen & lifecycle */
@InternalCoroutinesApi
@Composable
private fun ScreenLogging(navController: NavController) {
    LaunchedEffect(navController) {
        navController.currentBackStackEntryFlow.collect(
            object : FlowCollector<NavBackStackEntry> {
                override suspend fun emit(value: NavBackStackEntry) {
                    println("Logging Screen / ${value.destination.route} ${value.arguments}")
                }
            }
        )
    }
    val lifecycleOwner = LocalLifecycleOwner.current
    DisposableEffect(lifecycleOwner) {
        val observer = LifecycleEventObserver { _, event ->
            println("Logging Lifecycle / ${event.name}")
        }
        lifecycleOwner.lifecycle.addObserver(observer)
        onDispose {
            lifecycleOwner.lifecycle.removeObserver(observer)
        }
    }
}

@Composable
private fun BottomNavigationBar(navController: NavController) {
    val items = MainTab.values()
    BottomNavigation(
        modifier = Modifier.navigationBarsHeight(56.dp),
        contentColor = MaterialTheme.colors.background,
        backgroundColor = MaterialTheme.colors.background
    ) {
        val currentSelectedItem by navController.currentScreenAsState()
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
                selected = currentSelectedItem.route.startsWith(item.route),
                onClick = {
                    navController.navigate(item.route) {
                        // Avoid multiple copies of the same destination when
                        // reselecting the same item
                        launchSingleTop = true
                        // Restore state when reselecting a previously selected item
                        restoreState = true

                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                    }
                }
            )
        }
    }
}

/**
 * Adds an [NavController.OnDestinationChangedListener] to this [NavController] and updates the
 * returned [State] which is updated as the destination changes.
 */
@Stable
@Composable
private fun NavController.currentScreenAsState(): State<MainTab> {
    val selectedItem = remember { mutableStateOf(MainTab.Home) }

    DisposableEffect(this) {
        val listener = NavController.OnDestinationChangedListener { _, destination, _ ->
            for (value in MainTab.values()) {
                if (destination.hierarchy.any { it.route.orEmpty().startsWith(value.route) }) {
                    selectedItem.value = value
                    break
                }
            }
        }
        addOnDestinationChangedListener(listener)

        onDispose {
            removeOnDestinationChangedListener(listener)
        }
    }

    return selectedItem
}

@ExperimentalCoilApi
@Composable
private fun Navigation(navController: NavHostController) {
    NavHost(navController, startDestination = MainTab.Home.name) {
        MainTab.values().forEach { tab ->
            when (tab) {
                MainTab.Home -> homeNavGraph(navController, tab)
                MainTab.Catalog -> catalogNavGraph(navController, tab)
                MainTab.Cart -> cartNavGraph(navController, tab)
                MainTab.Shops -> shopsNavGraph(navController, tab)
                MainTab.Profile -> profileNavGraph(navController, tab)
            }
        }
        with(ScreenNav.FullCategoryNavScreen) {
            navigateToCategory(
                route = route,
                argument = argument0
            )
        }
    }
}
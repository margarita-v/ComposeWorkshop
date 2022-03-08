package com.example.composeworkshop.ui.main

import ru.surfstudio.compose.routing.NavigationRoute

/** Root for each tab of nested graph */
object MainNav {
    val HomeNavScreen = object : NavigationRoute {
        override val route: String = "HomeScreen"
    }

    val CatalogNavScreen = object : NavigationRoute {
        override val route: String = "CatalogScreen"
    }

    val CartNavScreen = object : NavigationRoute {
        override val route: String = "CartScreen"
    }

    val ShopsNavScreen = object : NavigationRoute {
        override val route: String = "ShopsScreen"
    }

    val ProfileNavScreen = object : NavigationRoute {
        override val route: String = "ProfileScreen"
    }
}
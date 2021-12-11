package com.example.composeworkshop.ui.main

import ru.surfstudio.compose.routing.NavScreen

object MainNav {
    val HomeNavScreen = object : NavScreen {
        override val route: String = "HomeScreen"
    }

    val CatalogNavScreen = object : NavScreen {
        override val route: String = "CatalogScreen"
    }

    val CartNavScreen = object : NavScreen {
        override val route: String = "CartScreen"
    }

    val ShopsNavScreen = object : NavScreen {
        override val route: String = "ShopsScreen"
    }

    val ProfileNavScreen = object : NavScreen {
        override val route: String = "ProfileScreen"
    }
}
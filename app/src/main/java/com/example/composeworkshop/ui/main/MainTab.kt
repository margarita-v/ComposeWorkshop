package com.example.composeworkshop.ui.main

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.composeworkshop.R
import com.example.composeworkshop.ui.main.navigation.TabNav

enum class MainTab(
    val route: String,
    @DrawableRes val iconResId: Int,
    @StringRes val titleResId: Int
) {

    Home(
        TabNav.HomeNavScreen.route,
        R.drawable.ic_home_tab,
        R.string.bottom_bar_home
    ),

    Catalog(
        TabNav.CatalogNavScreen.route,
        R.drawable.ic_catalog_tab,
        R.string.bottom_bar_catalog
    ),

    Cart(
        TabNav.CartNavScreen.route,
        R.drawable.ic_shopping_cart_tab,
        R.string.bottom_bar_shopping_cart
    ),

    Shops(
        TabNav.ShopsNavScreen.route,
        R.drawable.ic_shops_tab,
        R.string.bottom_bar_shops
    ),

    Profile(
        TabNav.ProfileNavScreen.route,
        R.drawable.ic_profile_tab,
        R.string.bottom_bar_profile
    );
}
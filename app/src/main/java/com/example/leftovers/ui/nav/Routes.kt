package com.example.leftovers.ui.nav

sealed class Routes(val route: String) {
    object RestaurantList: Routes("restaurantlist")
}
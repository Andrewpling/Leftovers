package com.example.leftovers.ui.nav

sealed class Routes(val route: String) {
    object RestaurantList: Routes("restaurantlist")
    object NewRestaurant: Routes("newRestaurant")
    object HomeScreen: Routes("homescreen")
    object LandingPage: Routes("landingpage")
}
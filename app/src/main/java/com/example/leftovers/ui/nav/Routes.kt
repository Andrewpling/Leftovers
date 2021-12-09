package com.example.leftovers.ui.nav

sealed class Routes(val route: String) {
    object RestaurantList: Routes("restaurantlist")
    object RestProfile: Routes("restprofile")
    object HomeScreen: Routes("homescreen")
    object FoodBankLandingPage: Routes("foobanklandingpage")
    object RestaurantLandingPage: Routes("restaurantlandingpage")
}
package com.example.leftovers.ui.nav

sealed class Routes(val route: String) {
    object RestaurantList: Routes("restaurantlist")
    object FoodBankList: Routes("foodbanklist")
    object RestProfile: Routes("restprofile")
    object BankProfile: Routes("bankprofile")
    object HomeScreen: Routes("homescreen")
    object FoodBankLandingPage: Routes("foobanklandingpage")
    object RestaurantLandingPage: Routes("restaurantlandingpage")
    object FoodBankUser: Routes("foodbankuser")
    object RestUser: Routes("restuser")
}
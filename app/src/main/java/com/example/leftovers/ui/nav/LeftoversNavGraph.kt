package com.example.leftovers.ui.nav

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.leftovers.ui.homescreen.HomeScreenView
import com.example.leftovers.ui.landingpage.FoodBankLandingPageView
import com.example.leftovers.ui.landingpage.LandingPageViewModel
import com.example.leftovers.ui.landingpage.RestaurantLandingPageView
//import com.example.leftovers.ui.landingpage.LandingPageView
import com.example.leftovers.ui.newrestaurant.NewRestaurantView
import com.example.leftovers.ui.newrestaurant.NewRestaurantViewModel
import com.example.leftovers.ui.restaurantList.RestaurantListView
import com.example.leftovers.ui.restaurantList.RestaurantListViewModel

@ExperimentalComposeUiApi
@ExperimentalFoundationApi
@Composable
fun LeftoversNavGraph(
    navController: NavHostController = rememberNavController()
){
    val vm: RestaurantListViewModel = viewModel()
    val vm2: LandingPageViewModel = viewModel()
    NavHost(
        navController = navController,
        startDestination = Routes.HomeScreen.route,
    ){
        composable(Routes.HomeScreen.route){
            HomeScreenView(vm2, navController)
        }
        composable(Routes.RestaurantList.route) {
            RestaurantListScreen(vm)
        }
        composable(Routes.NewRestaurant.route){
            val newRestaurantViewModel: NewRestaurantViewModel = viewModel()
            NewRestaurantView(
                newRestaurantViewModel,
                onAddRestaurant = { restaurant ->
                    vm.addRestaurant(restaurant)
//                    navController.navigate(Routes.RestaurantList.route)
                }
            )
        }
        composable(Routes.FoodBankLandingPage.route){
            FoodBankLandingPageView(vm2)
        }
        composable(Routes.RestaurantLandingPage.route){
            RestaurantLandingPageView(vm2)
        }
    }
}

@ExperimentalFoundationApi
@Composable
fun RestaurantListScreen(
    vm: RestaurantListViewModel
){
    val restaurants by vm.restaurants

    RestaurantListView(
        vm,
        restaurants,
        isReadyChange = vm::isReady

    )
}
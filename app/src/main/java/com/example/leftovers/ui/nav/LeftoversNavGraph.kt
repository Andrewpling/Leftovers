package com.example.leftovers.ui.nav

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.leftovers.ui.restaurantList.RestaurantList
import com.example.leftovers.ui.restaurantList.RestaurantListViewModel

@ExperimentalFoundationApi
@Composable
fun LeftoversNavGraph(
    navController: NavHostController = rememberNavController()
){
    val vm: RestaurantListViewModel = viewModel()
    NavHost(
        navController = navController,
        startDestination = Routes.RestaurantList.route,
    ){
        composable(Routes.RestaurantList.route){
            RestaurantListScreen(vm)
        }
    }
}

@ExperimentalFoundationApi
@Composable
fun RestaurantListScreen(
    vm: RestaurantListViewModel
){
    val restaurants by vm.restaurants
    RestaurantList(
        restaurants,
        isReadyChange = vm::isReady

    )
}
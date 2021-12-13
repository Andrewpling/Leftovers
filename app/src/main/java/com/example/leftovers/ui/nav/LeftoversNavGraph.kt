package com.example.leftovers.ui.nav

import android.content.Context
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.leftovers.ui.foodbankList.FoodBankListView
import com.example.leftovers.ui.foodbankList.FoodBankListViewModel
import com.example.leftovers.ui.homescreen.HomeScreenView
import com.example.leftovers.ui.landingpage.FoodBankLandingPageView
import com.example.leftovers.ui.landingpage.LandingPageViewModel
import com.example.leftovers.ui.landingpage.RestaurantLandingPageView
import com.example.leftovers.ui.profile.BankProfile
//import com.example.leftovers.ui.landingpage.LandingPageView
import com.example.leftovers.ui.profile.RestProfile
import com.example.leftovers.ui.restaurantList.RestaurantListView
import com.example.leftovers.ui.restaurantList.RestaurantListViewModel
import com.example.leftovers.ui.userprofile.BankUser
import com.example.leftovers.ui.userprofile.RestUser

@ExperimentalComposeUiApi
@ExperimentalFoundationApi
@Composable
fun LeftoversNavGraph(
    navController: NavHostController = rememberNavController()
){
    val vm: RestaurantListViewModel = viewModel()
    val vm2: LandingPageViewModel = viewModel()
    val vm3: FoodBankListViewModel = viewModel()
    val ctx: Context = LocalContext.current
    NavHost(
        navController = navController,
        startDestination = Routes.HomeScreen.route,
    ){
        composable(Routes.HomeScreen.route){
            HomeScreenView(vm2, navController)
        }
        composable(Routes.RestaurantList.route) {
            RestaurantListScreen(vm, navController)
        }
        composable(Routes.FoodBankList.route){
            FoodBankListScreen(vm3, navController)
        }
        composable(Routes.RestProfile.route){
            RestProfile(vm, ctx)
        }
        composable(Routes.BankProfile.route){
            BankProfile(vm3, ctx)
        }
        composable(Routes.FoodBankLandingPage.route){
            FoodBankLandingPageView(vm2, navController)
        }
        composable(Routes.RestaurantLandingPage.route){
            RestaurantLandingPageView(vm2, vm, navController)
        }
        composable(Routes.FoodBankUser.route){
            BankUser(vm3, ctx, navController)
        }
        composable(Routes.RestUser.route) {
            RestUser(vm, ctx, navController)
        }
    }
}

@ExperimentalFoundationApi
@Composable
fun RestaurantListScreen(
    vm: RestaurantListViewModel,
    nav: NavHostController
){
    val restaurants by vm.restaurants

    RestaurantListView(
        vm,
        restaurants,
        isReadyChange = vm::isReady,
        onSelectRest = vm::selectRest,
        nav

    )
}

@ExperimentalFoundationApi
@Composable
fun FoodBankListScreen(
    vm: FoodBankListViewModel,
    nav: NavHostController
){
    val foodBanks by vm.foodBanks

    FoodBankListView(
        vm,
        foodBanks,
        isReadyChange = vm::isReady,
        onSelectBank = vm::selectBank,
        nav

    )
}
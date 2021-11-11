package com.example.leftovers.ui.restaurantList
//
//import android.content.res.Configuration
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.lazy.LazyColumn
//import androidx.compose.foundation.lazy.itemsIndexed
//import androidx.compose.material.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.platform.LocalConfiguration
//import androidx.compose.ui.platform.LocalContext
//import androidx.lifecycle.viewmodel.compose.viewModel
//import com.example.leftovers.model.Restaurant
//import com.example.leftovers.ui.theme.FoodRow
//
//@Composable
//fun RestaurantListView(
//    restaurants: List<Restaurant>,
//    isReadyChange: (Restaurant) -> Unit
//){
//    Column(
//        horizontalAlignment = Alignment.CenterHorizontally,
//        modifier = Modifier.fillMaxWidth()
//    ){
//        val config = LocalConfiguration.current
//        if(config.orientation == Configuration.ORIENTATION_PORTRAIT){
//            LazyColumn{
//                itemsIndexed(restaurants){ idx, restaurant ->
//                    FoodRow(restaurant, restaurant.is_ready)
//                }
//            }
//        }
//    }
//}
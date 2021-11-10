package com.example.leftovers

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.material.Icon
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.fontResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.PopupProperties
import com.example.leftovers.model.Restaurant
import com.example.leftovers.ui.restaurantList.RestaurantList
import com.example.leftovers.ui.theme.LeftoversTheme
import com.example.leftovers.ui.theme.MainScreen
//import com.example.leftovers.ui.theme.MainScreen
import com.example.leftovers.ui.theme.Orange
import java.lang.reflect.Type

class MainActivity : ComponentActivity() {

    private var placeholderRestaurants = (1..10).map { restaurantNum ->
        Restaurant(1, "...", "Longhorn", "Germantown", 10, true)
    }

    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Log.d("TAG", "onCreate")
            LeftoversTheme {
                Surface(color = MaterialTheme.colors.background) {
                    MainScreen()
                }
            }
        }
    }
}

//@ExperimentalFoundationApi
//@Composable
//fun MainScreen(
//    restaurants: List<Restaurant>,
//    onDelete: (Restaurant) -> Unit,
//    donationReadyChange: (Restaurant) -> Unit,
//    onFilter: (String) -> Unit
//) {
//    Column() {
//        LazyColumn() {
//            itemsIndexed(restaurants) { idx, restaurant ->
//                RestaurantList(idx, restaurant, onDelete, donationReadyChange)
//            }
//        }
//    }
//}

@ExperimentalFoundationApi
@Preview(showBackground = true)
@Composable
fun DefaultPreview(){
    LeftoversTheme {
        Surface(color = MaterialTheme.colors.background) {
           MainScreen()
        }
    }
}



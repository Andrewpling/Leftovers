package com.example.leftovers.ui.theme

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.example.leftovers.model.Restaurant
import com.example.leftovers.ui.nav.LeftoversNavGraph
import com.example.leftovers.ui.nav.Routes
import com.example.leftovers.ui.restaurantList.RestaurantListViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch


//
//import androidx.compose.foundation.background
//import androidx.compose.foundation.clickable
//import androidx.compose.foundation.layout.*
//import androidx.compose.material.*
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.rounded.Menu
//import androidx.compose.runtime.*
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//
//@Composable
//fun MainScreen() {
//    var inputCheck by remember { mutableStateOf("") }
////    var currentPercentage by remember { mutableStateOf(Percentage.OFF) }
//    var result by remember { mutableStateOf("") }
//    var total by remember { mutableStateOf("") }
//    var showText by remember { mutableStateOf(false) }
//    var expanded by remember { mutableStateOf(false) }
//    val items = listOf("Store login", "", "C", "D", "E", "F")
//    val disabledValue = "B"
//    var selectedIndex by remember { mutableStateOf(0) }
//
//    Box(Modifier.fillMaxSize()){
//        Text("Leftovers",
//            style = MaterialTheme.typography.body1,
//            fontSize = 44.sp,
//            modifier =
////            Modifier.padding(all = 30.dp),
//            Modifier
//                .align(Alignment.TopCenter)
//                .padding(all = 30.dp),
//            color = Color.White,
//
//            )
//        FloatingActionButton(
//            onClick = {expanded = true},
//            modifier = Modifier
//                .align(Alignment.TopEnd)
//                .padding(12.dp),
//            backgroundColor = Color.White
//
//        ) {
//            Icon(Icons.Rounded.Menu, contentDescription = "Localized description")
//        }
//
//        DropdownMenu(
//            expanded = expanded,
//            onDismissRequest = { expanded = false },
//            modifier = Modifier
//                .fillMaxWidth()
//                .background(
//                    Color.Red
//                )
//        ) {
//            items.forEachIndexed { index, s ->
//                DropdownMenuItem(onClick = {
//                    selectedIndex = index
//                    expanded = false
//                }) {
//                    val disabledText = if (s == disabledValue) {
//                        " (Disabled)"
//                    } else {
//                        ""
//                    }
//                    Text(text = s + disabledText)
//                }
//            }
//        }
//    }
//}
//
//
//@Composable
//fun DropdownDemo() {
//    var expanded by remember { mutableStateOf(false) }
//    val items = listOf("A", "B", "C", "D", "E", "F")
//    val disabledValue = "B"
//    var selectedIndex by remember { mutableStateOf(0) }
//    Box(modifier = Modifier
//        .fillMaxSize()
//        .wrapContentSize(Alignment.TopStart)) {
//        Text(items[selectedIndex],modifier = Modifier
//            .fillMaxWidth()
//            .clickable(onClick = { expanded = true })
//            .background(
//                Color.Gray
//            ))
//        DropdownMenu(
//            expanded = expanded,
//            onDismissRequest = { expanded = false },
//            modifier = Modifier
//                .fillMaxWidth()
//                .background(
//                    Color.Red
//                )
//        ) {
//            items.forEachIndexed { index, s ->
//                DropdownMenuItem(onClick = {
//                    selectedIndex = index
//                    expanded = false
//                }) {
//                    val disabledText = if (s == disabledValue) {
//                        " (Disabled)"
//                    } else {
//                        ""
//                    }
//                    Text(text = s + disabledText)
//                }
//            }
//        }
//    }
//}
//
//

@ExperimentalComposeUiApi
@ExperimentalFoundationApi
@Composable
fun MainScreen(

//    restaurants: List<Restaurant>,
//    onDelete: (Restaurant) -> Unit,
//    donationReadyChange: (Restaurant) -> Unit,
//    onFilter: (String) -> Unit
) {
    val nav = rememberNavController()
    val scaffoldState= rememberScaffoldState()
    val scope = rememberCoroutineScope()

    Scaffold(
        scaffoldState = scaffoldState,
        drawerContent = {
            Text("Todos", modifier = Modifier.padding(16.dp))
            Column(modifier = Modifier.fillMaxWidth()){
                Text(
                    text = "+ Add Todos",
                    modifier = Modifier
                        .clickable {
                            nav.navigate(Routes.NewRestaurant.route) {
                                popUpTo(Routes.RestaurantList.route)
                            }
                        }
                        .padding(16.dp)
                )
            }
        },
        topBar = {
            TopBar(scaffoldState, scope )
        }
    ) {

        LeftoversNavGraph(nav)
//        LazyColumn() {
//            itemsIndexed(restaurants) { idx, restaurant ->
//                RestaurantList(idx, restaurant, onDelete, donationReadyChange)
//            }
        }
    }


@Composable
private fun TopBar(
    scaffoldState: ScaffoldState,
    scope: CoroutineScope
) {
    TopAppBar(
        title = { Text("Leftovers") },

        navigationIcon = {
            IconButton(onClick = {
                scope.launch {
                    scaffoldState.drawerState.apply {
                        if (isClosed) open() else close()
                    }
                }
            }) {
                Icon(Icons.Filled.List, contentDescription = "")
            }
        }

    )
}

package com.example.leftovers.ui.theme

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.example.leftovers.R
import com.example.leftovers.model.Restaurant
import com.example.leftovers.ui.nav.LeftoversNavGraph
import com.example.leftovers.ui.nav.Routes
import com.example.leftovers.ui.restaurantList.RestaurantListViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch



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
            
            Text("Leftovers", modifier = Modifier.padding(16.dp), fontSize = 24.sp, color = PrimaryTextColor)
            Column(modifier = Modifier.fillMaxWidth()){
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable(onClick = {
                            nav.navigate(Routes.RestaurantList.route) {
                                popUpTo(Routes.HomeScreen.route)
                            }
                        })
                        .padding(start = 10.dp)
                ){
                    //Image(painter = painterResource(id = R.mipmap.sniper_monkey_foreground), contentDescription ="" )
                    Image(imageVector = Icons.Default.Home, contentDescription = "")
                    Text(
                        text = "Home",
                        modifier = Modifier
                            .clickable {
                                nav.navigate(Routes.RestaurantList.route) {
                                    popUpTo(Routes.HomeScreen.route)
                                }
                            }
                            .padding(16.dp)
                    )
                }
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable(onClick = {
                            nav.navigate(Routes.RestaurantList.route) {
                                popUpTo(Routes.HomeScreen.route)
                            }
                        })
                        .padding(start = 10.dp)
                ){
                    Image(imageVector = Icons.Default.List, contentDescription = "")
                    Text(
                        text = "Restaurant List",
                        modifier = Modifier
                            .clickable {
                                nav.navigate(Routes.NewRestaurant.route) {
                                    popUpTo(Routes.HomeScreen.route)
                                }
                            }
                            .padding(16.dp)
                    )
                }
            }
        },
        topBar = {
            TopBar(scaffoldState, scope )
        }
    ) {

        LeftoversNavGraph(nav)
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

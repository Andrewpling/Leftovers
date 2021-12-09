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
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.example.leftovers.R
import com.example.leftovers.model.Restaurant
import com.example.leftovers.ui.landingpage.LandingPageViewModel
import com.example.leftovers.ui.nav.LeftoversNavGraph
import com.example.leftovers.ui.nav.Routes
import com.example.leftovers.ui.restaurantList.RestaurantListViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch



@ExperimentalComposeUiApi
@ExperimentalFoundationApi
@Composable
fun MainScreen(
    vm: LandingPageViewModel = viewModel()
){
    val nav = rememberNavController()
    val scaffoldState= rememberScaffoldState()
    val scope = rememberCoroutineScope()

    Scaffold(
        scaffoldState = scaffoldState,
        drawerContent = {

            //Header
            Text("Leftovers", modifier = Modifier.padding(16.dp), fontSize = 24.sp, color = PrimaryTextColor)

            //list contents
            Column(modifier = Modifier.fillMaxWidth()){

                //home button
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
                                //not logged in
                                if (vm.userMode.value == 0) {
                                    nav.navigate(Routes.HomeScreen.route) {
                                        popUpTo(Routes.HomeScreen.route)
                                    }
                                }
                                //restaurant user
                                else if (vm.userMode.value == 1) {
                                    nav.navigate(Routes.RestaurantLandingPage.route) {
                                        popUpTo(Routes.RestaurantLandingPage.route)
                                    }
                                }
                                //foodbank user
                                else if (vm.userMode.value == 2) {
                                    nav.navigate(Routes.FoodBankLandingPage.route) {
                                        popUpTo(Routes.FoodBankLandingPage.route)
                                    }
                                }
                            }
                            .padding(16.dp)
                    )
                }

                //Place lists
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable(onClick = {

                            //restaurant user
                            //TODO: Change to foodbank list route
                            if(vm.userMode.value == 1) {
                                nav.navigate(Routes.RestaurantList.route) {
                                    popUpTo(Routes.RestaurantLandingPage.route)
                                }
                            }

                            //foodbank user
                            else if(vm.userMode.value == 2){
                                nav.navigate(Routes.RestaurantList.route){
                                    popUpTo(Routes.FoodBankLandingPage.route)
                                }
                            }
                        })
                        .padding(start = 10.dp)
                ){

                    //restaurant user
                    if(vm.userMode.value == 1) {
                        Image(
                            imageVector = Icons.Default.List,
                            contentDescription = "list of food banks"
                        )
                        Text(
                            text = "Food Banks",
                            modifier = Modifier
                                .clickable {
                                    nav.navigate(Routes.RestaurantList.route)
                                }
                                .padding(16.dp)
                        )
                    }

                    //foodbank user
                    if(vm.userMode.value == 2) {
                        Image(
                            imageVector = Icons.Default.List,
                            contentDescription = "list of restaurants"
                        )
                        Text(
                            text = "Restaurants",
                            modifier = Modifier
                                .clickable {
                                    nav.navigate(Routes.RestaurantList.route)
                                }
                                .padding(16.dp)
                        )
                    }
                }
                Row(

                ){

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

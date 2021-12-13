package com.example.leftovers.ui.landingpage

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import coil.compose.rememberImagePainter
import com.example.leftovers.R
import com.example.leftovers.ui.nav.Routes
import com.example.leftovers.ui.restaurantList.RestaurantListViewModel

@Composable
fun RestaurantLandingPageView(
    vm: LandingPageViewModel = viewModel(),
    vm2: RestaurantListViewModel = viewModel(),
    nav: NavHostController
){

    val painter = rememberImagePainter(
        data = vm2.userRest.value?.picUrl,
        builder = {
            placeholder(R.mipmap.leftovers_logo_foreground)
        }
    )

    Column(
        modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally
    ) {
//        if(vm.userMode.value == 1){
//            Text("Restaurant")
//        }
//        else if(vm.userMode.value == 2){
//            Text("Food Bank")
//        }
//        else{
//            Text("ERROR")
//        }
        Image(painter = painterResource(R.mipmap.restaurant_placeholder_foreground) , contentDescription = "Placeholder", modifier = Modifier.size(256.dp))
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly, verticalAlignment = Alignment.CenterVertically
        ){
            Text(
                "Welcome, Restaurant User",
                fontSize = 32.sp,
                softWrap = true,
                overflow = TextOverflow.Clip,
                modifier = Modifier.padding(16.dp),
                textAlign = TextAlign.Center
            )
        }
        Button(
            onClick = {
                nav.navigate(Routes.RestUser.route)
            },
            modifier = Modifier.padding(16.dp)
        ){
            Text("My Profile")
        }
        Button(
            onClick = {
                vm.setUserMode(0)
                nav.navigate(Routes.HomeScreen.route){
                    popUpTo(Routes.HomeScreen.route)
                }
            }
        ) {
            Text("Logout")
        }
    }
}
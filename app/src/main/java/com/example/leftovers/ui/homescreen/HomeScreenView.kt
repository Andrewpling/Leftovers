package com.example.leftovers.ui.homescreen

import android.graphics.Color
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.leftovers.R
import com.example.leftovers.model.Restaurant
import com.example.leftovers.ui.landingpage.LandingPageViewModel
import com.example.leftovers.ui.nav.LeftoversNavGraph
import com.example.leftovers.ui.nav.Routes
import com.example.leftovers.ui.theme.PrimaryTextColor
import com.example.leftovers.ui.theme.SecondaryColor
import java.time.format.TextStyle


@ExperimentalComposeUiApi
@Composable
fun HomeScreenView(
  //  vm: LandingPageViewModel = viewModel(),
    vm: LandingPageViewModel = viewModel(),
    nav: NavHostController
//    onAddRestaurant: (Restaurant) -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.Center
        ) {
//            Text(text , fontSize = 24.sp, color = PrimaryTextColor)
            Image(
                painter = painterResource(id = R.mipmap.leftovers_logo_foreground),
                contentDescription = "",
                modifier = Modifier.size(400.dp)
            )
        }
        Row(
            horizontalArrangement = Arrangement.Center
        ){
            Text(
                text = "Login",
                fontSize = 24.sp
            )
        }
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.padding(16.dp)
        ){
            Button(
                modifier = Modifier.padding(8.dp),
                onClick = {
                    //vm.setUserMode("restaurant")
                    vm.setUserMode(1)
                    nav.navigate(Routes.RestaurantLandingPage.route) {
                        popUpTo(Routes.HomeScreen.route)
                    }

                }
            ) {
                Text("Restaurant")
            }
            Button(
                modifier = Modifier.padding(8.dp),
                onClick = {
                    //vm.setUserMode("foodBank")
                    vm.setUserMode(2)
                    nav.navigate(Routes.FoodBankLandingPage.route) {
                        popUpTo(Routes.HomeScreen.route)
                    }

                }
            ) {
                Text("Food Bank")
            }
        }
    }
//    Button(onClick = {
//        val restaurant = vm.makeRestaurant()
//        //onAddRestaurant(restaurant)
//    }) {
//        Text(text = "hi")
//    }
}

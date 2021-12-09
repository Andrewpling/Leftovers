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
import com.example.leftovers.R
import com.example.leftovers.ui.nav.Routes

@Composable
fun RestaurantLandingPageView(
    vm: LandingPageViewModel = viewModel(),
    nav: NavHostController
){

    Column(
        modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if(vm.userMode.value == 1){
            Text("Restaurant")
        }
        else if(vm.userMode.value == 2){
            Text("Food Bank")
        }
        else{
            Text("ERROR")
        }
        Image(painter = painterResource(id = R.mipmap.tofu_foreground), contentDescription = "Placeholder", modifier = Modifier.size(256.dp))
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly, verticalAlignment = Alignment.CenterVertically
        ){
            Text(
                "Welcome, Big Ol' Juicy Tofu",
                fontSize = 32.sp,
                softWrap = true,
                overflow = TextOverflow.Clip,
                modifier = Modifier.padding(16.dp),
                textAlign = TextAlign.Center
            )
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
package com.example.leftovers.ui.landingpage

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun LandingPageView(
    vm: LandingPageViewModel = viewModel()
){
    if(vm.userMode.value == "restaurant"){
        Text("This is the restaurant page")
    }
    if(vm.userMode.value == "foodBank"){
        Text("This is the food bank page")
    }
    else{
        Text("Error")
    }
}
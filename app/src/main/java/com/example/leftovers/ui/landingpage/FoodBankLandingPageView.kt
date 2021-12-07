package com.example.leftovers.ui.landingpage


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.leftovers.R

@Composable
fun FoodBankLandingPageView(
    vm: LandingPageViewModel = viewModel()
){
    Column(
        modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(painter = painterResource(id = R.mipmap.foodforthought_foreground), contentDescription = "Placeholder", modifier = Modifier.size(256.dp))
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly, verticalAlignment = Alignment.CenterVertically
        ){
            Text("Welcome, Food for Thought", fontSize = 32.sp, modifier = Modifier.padding(16.dp), textAlign = TextAlign.Center)
        }
    }
}
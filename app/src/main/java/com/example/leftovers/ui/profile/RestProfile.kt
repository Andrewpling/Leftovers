package com.example.leftovers.ui.profile


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberImagePainter
import com.example.leftovers.R
import com.example.leftovers.model.Restaurant
import com.example.leftovers.ui.landingpage.LandingPageViewModel
import com.example.leftovers.ui.restaurantList.RestaurantListViewModel


@ExperimentalComposeUiApi
@Composable
fun RestProfile(
    vm: RestaurantListViewModel = viewModel()
) {

    val data = vm.selectedRest.value?.picUrl

//    val painter = rememberImagePainter(
//        data = ,
//        builder = {
//            placeholder(R.mipmap.sniper_monkey_foreground)
//        }
//    )

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    ){
        Text("$data")
//        Image(
//            modifier = Modifier
//                .size(256.dp),
//            painter = painter,
//            contentDescription = "Full picture",
//            alignment = Alignment.Center
//        )
    }

}

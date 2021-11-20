package com.example.leftovers.ui.newrestaurant

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.leftovers.model.Restaurant


@ExperimentalComposeUiApi
@Composable
fun NewRestaurantView(
    vm: NewRestaurantViewModel = viewModel(),
    onAddRestaurant: (Restaurant) -> Unit
) {
    Button(onClick = {
        val restaurant = vm.makeRestaurant()
        //onAddRestaurant(restaurant)
    }) {
        Text(text = "hi")
    }
}

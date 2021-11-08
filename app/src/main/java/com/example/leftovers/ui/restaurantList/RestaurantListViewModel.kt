package com.example.leftovers.ui.restaurantList

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.leftovers.model.Restaurant

class RestaurantListViewModel : ViewModel() {
    private val _restaurants: MutableState<List<Restaurant>> = mutableStateOf(listOf())
    val restaurants: State<List<Restaurant>> = _restaurants



}
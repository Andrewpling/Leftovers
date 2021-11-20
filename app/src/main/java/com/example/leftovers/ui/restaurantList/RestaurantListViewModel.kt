package com.example.leftovers.ui.restaurantList

import android.app.Application
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.leftovers.data.IRestaurantRepository
import com.example.leftovers.data.impl.RestaurantsDatabaseRepository
import com.example.leftovers.model.Restaurant
import kotlinx.coroutines.launch

class RestaurantListViewModel(app: Application) : AndroidViewModel(app) {
    private val _restaurants: MutableState<List<Restaurant>> = mutableStateOf(listOf())
    val restaurants: State<List<Restaurant>> = _restaurants

    private val _repository: IRestaurantRepository = RestaurantsDatabaseRepository(app)

    init {
        viewModelScope.launch {
            _restaurants.value = _repository.getRestaurants()
        }
    }
        fun addRestaurant(restaurant: Restaurant){
            viewModelScope.launch {
                _repository.addRestaurant(restaurant)
                _restaurants.value = _repository.getRestaurants()
            }
        }

        fun isReady(restaurant: Restaurant){
            viewModelScope.launch {
                _repository.toggleReady(restaurant)
                _restaurants.value = _repository.getRestaurants()
            }
        }

        fun initializeValues(){
            addRestaurant(Restaurant(1, "img1", "Longhorn", "New York City", 10, true))
            addRestaurant(Restaurant(2, "img2", "Red Lobster", "Michael's Butt", 9, false))
            addRestaurant(Restaurant(3, "img3", "Buffalo Wild Wings", "South St", 15, true))
            addRestaurant(Restaurant(4, "img4", "Greene Turtle", "Kevin's House", 10, true))
            addRestaurant(Restaurant(5, "img5", "Iron Age", "East Ct", 10, false))
            addRestaurant(Restaurant(6, "img6", "McDonalds", "North St", 113, true))
        }
    }

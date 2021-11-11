package com.example.leftovers.ui.restaurantList

import android.app.Application
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
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

        fun isReady(restaurant: Restaurant){
            viewModelScope.launch {
                _repository.toggleReady(restaurant)
                _restaurants.value = _repository.getRestaurants()
            }
        }
    }

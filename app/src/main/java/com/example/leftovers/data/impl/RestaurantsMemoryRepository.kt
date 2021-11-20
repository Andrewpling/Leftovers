package com.example.leftovers.data.impl

import com.example.leftovers.data.IRestaurantRepository
import com.example.leftovers.model.Restaurant
import kotlinx.coroutines.delay

class RestaurantsMemoryRepository: IRestaurantRepository {

    private var _restaurants = listOf<Restaurant>()

    init {
        _restaurants = (0..20).map { i ->
            Restaurant(i, "path", "name", "location", 5,  true)
        }
    }

    override suspend fun getRestaurants(): List<Restaurant> {
        return _restaurants
    }

    override suspend fun deleteRestaurant(restaurant: Restaurant) {
        delay(5000)
        val idx = _restaurants.indexOf(restaurant)
        _restaurants = _restaurants.subList(0, idx) + _restaurants.subList(idx+1, _restaurants.size)
    }

    override suspend fun addRestaurant(restaurant: Restaurant) {
    delay(5000)
        _restaurants = listOf(restaurant) + _restaurants
    }

    override suspend fun toggleReady(restaurant: Restaurant) {
        val newRestaurant = restaurant.copy(is_ready = !restaurant.is_ready)
        val idx = _restaurants.indexOf(restaurant)
        _restaurants = _restaurants.subList(0, idx) + listOf(newRestaurant) + _restaurants.subList(idx+1, _restaurants.size)
    }
}

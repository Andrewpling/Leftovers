package com.example.leftovers.data

import com.example.leftovers.model.Restaurant

interface IRestaurantRepository {
    suspend fun getRestaurants(): List<Restaurant>
    suspend fun deleteRestaurant(idx: Int)
    suspend fun addRestaurant(restaurant: Restaurant)
    suspend fun toggleAvailable(idx: Int)
    suspend fun filter(search: String)
}
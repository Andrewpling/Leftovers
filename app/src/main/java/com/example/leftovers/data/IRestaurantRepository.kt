package com.example.leftovers.data

import com.example.leftovers.model.FoodBank
import com.example.leftovers.model.Restaurant

interface IRestaurantRepository {
    suspend fun getRestaurants(): List<Restaurant>
    suspend fun addRestaurant(restaurant: Restaurant)
    suspend fun toggleRestaurantReady(restaurant: Restaurant)


    //suspend fun filter(search: String)
}
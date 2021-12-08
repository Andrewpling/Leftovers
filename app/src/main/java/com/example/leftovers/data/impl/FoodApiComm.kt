package com.example.leftovers.data.impl

import com.example.leftovers.data.IRestaurantRepository
import com.example.leftovers.model.FoodBank
import com.example.leftovers.model.Restaurant
import com.example.leftovers.network.IFoodFetcher

class FoodApiComm (
    private val db: RestaurantsDatabaseRepository,
    private val foodFetcher: IFoodFetcher
    ) : IRestaurantRepository {

    override suspend fun getRestaurants(): List<Restaurant> {
        if (db.getRestaurants().isEmpty()) {
            val rests = foodFetcher.fetchRest()
            rests.forEach { rest -> db.addRestaurant(rest) }
        }
        return db.getRestaurants()
    }


    override suspend fun addRestaurant(restaurant: Restaurant) {
        db.addRestaurant(restaurant)
    }

    override suspend fun toggleRestaurantReady(restaurant: Restaurant) {
        TODO("Not yet implemented")
    }

    override suspend fun updateRestaurant(restaurant: Restaurant) {
        TODO("Not yet implemented")
    }
}
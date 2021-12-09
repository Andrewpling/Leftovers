package com.example.leftovers.data.api

import com.example.leftovers.data.IRestaurantRepository
import com.example.leftovers.data.impl.RestaurantsDatabaseRepository
import com.example.leftovers.model.Restaurant
import com.example.leftovers.network.IFoodFetcher

class RestaurantApiComm (
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
        db.toggleRestaurantReady(restaurant)
    }

}
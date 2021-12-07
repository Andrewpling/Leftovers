package com.example.leftovers.data.impl

import android.app.Application
import androidx.room.Room
import com.example.leftovers.data.IRestaurantRepository
import com.example.leftovers.data.RestaurantsDatabase
import com.example.leftovers.model.Restaurant

class RestaurantsDatabaseRepository (app: Application) : IRestaurantRepository {
    private val db: RestaurantsDatabase

    init{
        db = Room.databaseBuilder(
            app,
            RestaurantsDatabase::class.java,
            "restaurants.db"
        ).fallbackToDestructiveMigration().build()
    }

    private var _restaurants: List<Restaurant> = listOf()

    override suspend fun getRestaurants(): List<Restaurant> {
        return db.restaurantDao().getRestaurants()
    }


    override suspend fun addRestaurant(restaurant: Restaurant) {
        return db.restaurantDao().addRestaurant(restaurant)
    }

    override suspend fun toggleReady(restaurant: Restaurant) {
        val newRestaurant = restaurant.copy(is_ready = !restaurant.is_ready)
        db.restaurantDao().updateRestaurant(newRestaurant)
    }

    override suspend fun updateRestaurant(restaurant: Restaurant) {
        TODO("Not yet implemented")
    }


}
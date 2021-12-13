package com.example.leftovers.data.impl

import android.app.Application
import androidx.room.Room
import com.example.leftovers.data.IRestaurantRepository
import com.example.leftovers.data.db.RestaurantsDatabase
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

    override suspend fun getRestUser(): Restaurant {
        return db.restaurantDao().getRestUser()
    }

    override suspend fun updateRestaurant(restaurant: Restaurant) {
        return db.restaurantDao().updateRestaurant(restaurant)
    }

    override suspend fun addRestaurant(restaurant: Restaurant) {
        return db.restaurantDao().addRestaurant(restaurant)
    }

    override suspend fun toggleRestaurantReady(restaurant: Restaurant) {
        val newRestaurant = restaurant.copy(isAccepting = !restaurant.isAccepting)
        db.restaurantDao().updateRestaurant(newRestaurant)
    }



}
package com.example.leftovers.data.impl

import android.app.Application
import com.example.leftovers.data.IRestaurantDatabase
import com.example.leftovers.model.Restaurant

class RestaurantsDatabase (app: Application) : IRestaurantDatabase {
    private val db: RestaurantsDatabase
    private var _restaurants: List<Restaurant> = listOf()

    init {
        db = Room.databaseBuilder(
            app,
            RestaurantsDatabase::class.java,
            "restaurants.db"
        ).fallbackToDestructiveMigration().build()
    }


}
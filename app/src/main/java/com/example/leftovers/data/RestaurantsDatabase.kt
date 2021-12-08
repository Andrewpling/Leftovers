package com.example.leftovers.data

import androidx.room.*
import com.example.leftovers.model.Restaurant

@Dao
interface RestaurantsDao {
    @Query("SELECT id, name, location, distance, picUrl, isAccepting FROM restaurant")
    suspend fun getRestaurants(): List<Restaurant>

    @Insert
    suspend fun addRestaurant(restaurant: Restaurant)

    @Update
    suspend fun updateRestaurant(restaurant: Restaurant)


}

@Database(entities = [Restaurant::class], version = 2 , exportSchema = false)
abstract class RestaurantsDatabase: RoomDatabase(){
    abstract fun restaurantDao(): RestaurantsDao
}
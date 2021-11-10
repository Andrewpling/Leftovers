package com.example.leftovers.data

import androidx.room.*
import com.example.leftovers.model.Restaurant

@Dao
interface RestaurantsDao {
    @Query("SELECT id, img_path, name, location, distance, is_ready FROM restaurant")
    suspend fun getRestaurants(): List<Restaurant>

    @Update
    suspend fun updateRestaurant(restaurant: Restaurant)


}

@Database(entities = [Restaurant::class], version = 1, exportSchema = false)
abstract class RestaurantsDatabase: RoomDatabase(){
    abstract fun restaurantDao(): RestaurantsDao
}
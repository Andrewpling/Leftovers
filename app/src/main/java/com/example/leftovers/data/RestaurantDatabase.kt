package com.example.leftovers.data

import com.example.leftovers.model.Restaurant

@Dao
interface RestaurantDatabase {
    @Query("SELECT img, name, location, distance, is_ready FROM restaurant")
    suspend fun getRestaurants(): List<Restaurant>

    @Update
    suspend fun updateRestaurant(restaurant: Restaurant)


}

@Database(entitities = [Song::class], version = 1, exportSchema = false)
abstract class RestaurantDatabase: RoomDatabase(){
    abstract fun restaurantDao(): RestaurantDao
}
package com.example.leftovers.data

import androidx.room.*
import com.example.leftovers.model.FoodBank
import com.example.leftovers.model.Restaurant

@Dao
interface BanksDao {
    @Query("SELECT id, name, location, distance, picUrl, isAccepting FROM foodbank")
    suspend fun getBanks(): List<FoodBank>

    @Insert
    suspend fun addBank(foodBank: FoodBank)

    @Update
    suspend fun updateBank(foodBank: FoodBank)


}

@Database(entities = [FoodBank::class], version = 1 , exportSchema = false)
abstract class BanksDatabase: RoomDatabase(){
    abstract fun banksDao(): BanksDao
}
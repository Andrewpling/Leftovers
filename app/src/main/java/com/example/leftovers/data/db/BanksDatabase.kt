package com.example.leftovers.data.db

import androidx.room.*
import com.example.leftovers.model.FoodBank
import com.example.leftovers.model.Restaurant

@Dao
interface BanksDao {
    @Query("SELECT id, name, location, distance, picUrl, isAccepting FROM foodbank")
    suspend fun getBanks(): List<FoodBank>

    @Query("SELECT id, name, location, distance, picUrl, isAccepting FROM foodbank WHERE id = 1")
    suspend fun getBankUser(): FoodBank

    @Insert
    suspend fun addBank(foodBank: FoodBank)

    @Update
    suspend fun updateBank(foodBank: FoodBank)

//    @Update
//    suspend fun submitBank(x: String, y: String)
}

@Database(entities = [FoodBank::class], version = 1, exportSchema = false)
abstract class BanksDatabase: RoomDatabase(){
    abstract fun banksDao(): BanksDao
}
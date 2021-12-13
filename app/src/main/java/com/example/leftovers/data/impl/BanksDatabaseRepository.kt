package com.example.leftovers.data.impl

import android.app.Application
import androidx.room.Room
import com.example.leftovers.data.db.BanksDatabase
import com.example.leftovers.data.IBankRepository
import com.example.leftovers.data.IRestaurantRepository
import com.example.leftovers.data.db.RestaurantsDatabase
import com.example.leftovers.model.FoodBank
import com.example.leftovers.model.Restaurant

class BanksDatabaseRepository (app: Application) : IBankRepository {

    private val db: BanksDatabase

    init{
        db = Room.databaseBuilder(
            app,
            BanksDatabase::class.java,
            "banks.db"
        ).fallbackToDestructiveMigration().build()
    }

    private var _banks: List<FoodBank> = listOf()

    override suspend fun getBanks(): List<FoodBank> {
        return db.banksDao().getBanks()
    }

    override suspend fun addBank(foodBank: FoodBank) {
        return db.banksDao().addBank(foodBank)
    }

    override suspend fun toggleBankReady(foodBank: FoodBank) {
        val newBank = foodBank.copy(isAccepting = !foodBank.isAccepting)
        db.banksDao().updateBank(newBank)
    }

}
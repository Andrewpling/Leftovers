package com.example.leftovers.data.api

import com.example.leftovers.data.IBankRepository
import com.example.leftovers.data.impl.BanksDatabaseRepository
import com.example.leftovers.data.impl.RestaurantsDatabaseRepository
import com.example.leftovers.model.FoodBank
import com.example.leftovers.model.Restaurant
import com.example.leftovers.network.IFoodFetcher

class BankApiComm (
    private val db: BanksDatabaseRepository,
    private val foodFetcher: IFoodFetcher
) : IBankRepository {

    override suspend fun getBanks(): List<FoodBank> {
        if (db.getBanks().isEmpty()) {
            val banks = foodFetcher.fetchBanks()
            banks.forEach { bank -> db.addBank(bank) }
        }
        return db.getBanks()
    }

    override suspend fun addBank(foodBank: FoodBank) {
        db.addBank(foodBank)
    }

    override suspend fun toggleBankReady(foodBank: FoodBank) {
        db.toggleBankReady(foodBank)
    }

}
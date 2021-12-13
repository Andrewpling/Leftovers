package com.example.leftovers.data

import com.example.leftovers.model.FoodBank

interface IBankRepository {
    suspend fun getBanks(): List<FoodBank>
    suspend fun addBank(foodBank: FoodBank)
    suspend fun getBankUser(): FoodBank
    suspend fun updateBank(foodBank: FoodBank)
    suspend fun toggleBankReady(foodBank: FoodBank)
}
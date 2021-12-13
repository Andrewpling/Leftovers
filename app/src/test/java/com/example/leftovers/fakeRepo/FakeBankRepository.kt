package com.example.leftovers.fakeRepo

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.example.leftovers.data.IBankRepository
import com.example.leftovers.model.FoodBank

class FakeBankRepository : IBankRepository{

    private var isAccepting = false

    private val banks = mutableListOf<FoodBank>()

    override suspend fun getBanks(): List<FoodBank> {
        return banks
    }

    override suspend fun addBank(foodBank: FoodBank) {
        banks.add(foodBank)
    }

    override suspend fun toggleBankReady(foodBank: FoodBank) {
        isAccepting = !foodBank.isAccepting
    }
}
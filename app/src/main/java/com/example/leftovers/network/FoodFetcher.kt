package com.example.leftovers.network

import android.app.Application
import com.example.leftovers.model.FoodBank
import com.example.leftovers.model.Restaurant
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.Request

interface IFoodFetcher{
    suspend fun fetchBanks(): List<FoodBank>
    suspend fun fetchRest(): List<Restaurant>
}

class FoodFetcher(
    private val app: Application
): IFoodFetcher{
    private val URL = "https://androidclass.herokuapp.com/foodBanks"
    private val URL2 = "https://androidclass.herokuapp.com/restaurants"
    override suspend fun fetchBanks(): List<FoodBank> {
        return withContext(Dispatchers.IO) {
            val client = OkHttpClient()
            val request = Request.Builder().url(URL).get().build()
            val response = client.newCall(request).execute()
            val json = response.body?.string()
            if(json != null) {
                val gson = Gson()
                val typeTokens = object : TypeToken<List<FoodBank>>() {}
                val banks = gson.fromJson<List<FoodBank>>(json, typeTokens.type)
                return@withContext banks
            } else {
                return@withContext listOf()
            }
        }
    }

    override suspend fun fetchRest(): List<Restaurant> {
        return withContext(Dispatchers.IO) {
            val client = OkHttpClient()
            val request = Request.Builder().url(URL).get().build()
            val response = client.newCall(request).execute()
            val json = response.body?.string()
            if(json != null) {
                val gson = Gson()
                val typeTokens = object : TypeToken<List<Restaurant>>() {}
                val rest = gson.fromJson<List<Restaurant>>(json, typeTokens.type)
                return@withContext rest
            } else {
                return@withContext listOf()
            }
        }
    }
}




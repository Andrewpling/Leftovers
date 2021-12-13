package com.example.leftovers.ui.foodbankList

import android.app.Application
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.leftovers.data.IBankRepository
import com.example.leftovers.data.IRestaurantRepository
import com.example.leftovers.data.api.BankApiComm
import com.example.leftovers.data.api.RestaurantApiComm
import com.example.leftovers.data.impl.BanksDatabaseRepository
import com.example.leftovers.data.impl.RestaurantsDatabaseRepository
import com.example.leftovers.model.FoodBank
import com.example.leftovers.model.Restaurant
import com.example.leftovers.network.FoodFetcher
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class FoodBankListViewModel(app: Application) : AndroidViewModel(app) {
    private val _foodBanks: MutableState<List<FoodBank>> = mutableStateOf(listOf())
    val foodBanks: State<List<FoodBank>> = _foodBanks

    private val _selectedBank: MutableState<FoodBank?>
    val selectedBank: State<FoodBank?>

    private val _userBank: MutableState<FoodBank?> = mutableStateOf(null)
    val userBank: State<FoodBank?> = _userBank

    private val _repository: IBankRepository = BankApiComm(BanksDatabaseRepository(app), FoodFetcher(app))

    init {
        viewModelScope.launch {
            _foodBanks.value = _repository.getBanks()
            _userBank.value = _repository.getBankUser()
        }
        _selectedBank = mutableStateOf(null)
        selectedBank = _selectedBank






    }
    fun addRestaurant(foodBank: FoodBank){
        viewModelScope.launch {
            _repository.addBank(foodBank)
            _foodBanks.value = _repository.getBanks()
        }
    }

    fun isReady(foodBank: FoodBank){
        viewModelScope.launch {
            _repository.toggleBankReady(foodBank)
            _foodBanks.value = _repository.getBanks()
        }
    }

    fun selectBank(foodBank: FoodBank){
        _selectedBank.value = foodBank
    }

    fun updateBank(foodBank: FoodBank){
        viewModelScope.launch {
            _repository.updateBank(foodBank)
            _foodBanks.value = _repository.getBanks()
            _userBank.value = _repository.getBankUser()
        }
    }

//        fun initializeValues(){
//            addRestaurant(Restaurant(1, "img1", "Longhorn", "New York City", 10, true))
//            addRestaurant(Restaurant(2, "img2", "Red Lobster", "Michael's Butt", 9, false))
//            addRestaurant(Restaurant(3, "img3", "Buffalo Wild Wings", "South St", 15, true))
//            addRestaurant(Restaurant(4, "img4", "Greene Turtle", "Kevin's House", 10, true))
//            addRestaurant(Restaurant(5, "img5", "Iron Age", "East Ct", 10, false))
//            addRestaurant(Restaurant(6, "img6", "McDonald's", "North St", 113, true))
//        }
}

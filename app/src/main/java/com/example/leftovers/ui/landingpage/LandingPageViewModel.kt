package com.example.leftovers.ui.landingpage

import android.app.Application
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.leftovers.data.IRestaurantRepository
import com.example.leftovers.model.FoodBank
import com.example.leftovers.model.Restaurant
import kotlinx.coroutines.launch
import kotlinx.coroutines.selects.select


class LandingPageViewModel(app: Application) : AndroidViewModel(app){
    private val _foodbanks: MutableState<List<FoodBank>> = mutableStateOf(listOf())
    val foodbanks: State<List<FoodBank>> = _foodbanks

    private val _selectedFood: MutableState<FoodBank?>
    val selectedFood: State<FoodBank?>

    private val _userMode: MutableState<Int>
    val userMode: State<Int>



    //private val _repository: IRestaurantRepository =
    //TODO: Finish this ^^^


    init{
        viewModelScope.launch {
           // _foodbanks.value = _repository.getBanks()
        }
        _selectedFood = mutableStateOf(null)
        selectedFood = _selectedFood
        _userMode = mutableStateOf(0)
        userMode = _userMode
    }

    fun setUserMode(mode: Int){
        _userMode.value = mode
    }




}


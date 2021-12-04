package com.example.leftovers.ui.landingpage

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel


class LandingPageViewModel : ViewModel(){
    private val _userMode: MutableState<String> = mutableStateOf("")
    val userMode: State<String> = _userMode

    fun setUserMode(mode: String){
        _userMode.value = mode
    }
}
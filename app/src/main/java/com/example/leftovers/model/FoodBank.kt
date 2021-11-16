package com.example.leftovers.model

data class FoodBank(
    val name: String,
    val location: String,
    val distance: Int,
    val isAccepting: Boolean
){
}
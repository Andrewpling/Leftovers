package com.example.leftovers.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class FoodBank(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    val location: String,
    val distance: Int,
    val isAccepting: Boolean
){
}
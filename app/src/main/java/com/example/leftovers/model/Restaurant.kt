package com.example.leftovers.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Restaurant(
    @PrimaryKey
    val id: Int,
    val name: String,
    val location: String,
    val distance: Int,
    val picUrl: String,
    val isAccepting: Boolean
){
}

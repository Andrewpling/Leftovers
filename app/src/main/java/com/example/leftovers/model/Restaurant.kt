package com.example.leftovers.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Restaurant (
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val img_path: String,
    val name: String,
    val location: String,
    val distance: Int,
   // val type: String,
    //@ColumnInfo(name = "is_ready")
    val is_ready: Boolean
    ){
}

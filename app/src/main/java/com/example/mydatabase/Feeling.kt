package com.example.mydatabase

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "feeling")
data class Feeling (
    @PrimaryKey (autoGenerate = true)
    val id: Int,
    val mode: Int, //1 = Sad, 2 = Neutral, 3 =  Happy
    val remarks: String,
    val created_at: Long = System.currentTimeMillis()
)


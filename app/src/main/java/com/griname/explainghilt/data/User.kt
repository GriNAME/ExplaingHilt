package com.griname.explainghilt.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_table")
data class User(
    val name: String,
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0
)

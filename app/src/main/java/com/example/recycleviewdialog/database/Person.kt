package com.example.recycleviewdialog.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "persons")
data class Person(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val name: String,
    val surname: String,
    val age: Int
)

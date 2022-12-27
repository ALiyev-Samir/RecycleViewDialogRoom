package com.example.recycleviewdialog.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface PersonsDao {
    @Query("SELECT * FROM persons")
    fun getAllPersons(): List<Person>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addPerson(person: Person)
}
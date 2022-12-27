package com.example.recycleviewdialog.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Person::class], version = 1)
abstract class MyDatabase: RoomDatabase() {
    abstract fun personsDao(): PersonsDao

    companion object {
        @Volatile
        var INSTANCE: MyDatabase? = null
        fun getInstance(context: Context): MyDatabase {
            if(INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(context, MyDatabase::class.java, "my_db")
                    .allowMainThreadQueries()
                    .build()
            }
            return INSTANCE!!
        }
    }
}
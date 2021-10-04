package com.example.myapplication.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.myapplication.model.Pokemon

@Database(entities = [Pokemon::class], version = 1)
abstract class pokemonDatabase : RoomDatabase() {
    abstract fun pokemonDao(): pokemonDao
    companion object {
        val DATABASE_NAME: String = "pokemon"
    }
}
package com.stathis.secondassignment.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.stathis.secondassignment.model.Country

@Database(entities = arrayOf(Country::class), version = 3, exportSchema = false)
abstract class CountriesDatabase : RoomDatabase() {

    abstract fun countriesDao(): CountriesDao

    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: CountriesDatabase? = null

        fun getDatabase(context: Context): CountriesDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: kotlin.synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    CountriesDatabase::class.java,
                    "countries_db"
                ).fallbackToDestructiveMigration().build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }
}
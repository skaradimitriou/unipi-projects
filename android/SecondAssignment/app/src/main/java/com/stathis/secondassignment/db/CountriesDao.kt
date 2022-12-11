package com.stathis.secondassignment.db

import androidx.room.*
import com.stathis.secondassignment.model.Country
import kotlinx.coroutines.flow.Flow

@Dao
interface CountriesDao {

    @Query("SELECT * FROM countries ORDER BY name ASC")
    fun getAllCountries(): Flow<List<Country>>

    @Query("SELECT * FROM countries WHERE name LIKE :countryName")
    fun searchCountriesByName(countryName: String): Flow<List<Country>>

    @Query("SELECT * FROM countries WHERE id=:id")
    fun getCountryDetails(id: Int): Flow<Country?>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(country: Country)

    @Update(entity = Country::class)
    suspend fun update(country: Country)

    @Delete
    suspend fun delete(country: Country): Int

    @Query("DELETE FROM countries")
    suspend fun deleteAll()
}
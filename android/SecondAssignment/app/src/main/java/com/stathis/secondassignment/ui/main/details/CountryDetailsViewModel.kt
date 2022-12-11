package com.stathis.secondassignment.ui.main.details

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.stathis.secondassignment.R
import com.stathis.secondassignment.abstraction.BaseViewModel
import com.stathis.secondassignment.db.CountriesDatabase
import com.stathis.secondassignment.model.Country
import com.stathis.secondassignment.model.CountryDetail
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CountryDetailsViewModel(app: Application) : BaseViewModel(app) {

    private val localDb by lazy { CountriesDatabase.getDatabase(app).countriesDao() }

    /**
     * LiveData that notifies about the country deletion.
     */

    val countryDeleted: LiveData<Boolean>
        get() = _countryDeleted

    private val _countryDeleted = MutableLiveData(false)

    val adapter = CountryDetailsAdapter()

    /*
     * Method that launches a coroutine and performs the query to get all the country data
     * based on the country's id.
     */

    fun getCountryDetails(id: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            localDb.getCountryDetails(id = id).collect { country ->
                country?.let { bindCountryProperties(country) }
            }
        }
    }

    /*
     * Method that transforms the country's properties into a list of a different model and
     * binds that list to the UI.
     */
    private fun bindCountryProperties(country: Country) {
        val list = listOf(
            CountryDetail(
                image = R.drawable.ic_location,
                title = getString(R.string.detail_country),
                value = country.name
            ),
            CountryDetail(
                image = R.drawable.ic_capital,
                title = getString(R.string.detail_capital),
                value = country.capital
            ),
            CountryDetail(
                image = R.drawable.ic_people,
                title = getString(R.string.detail_population),
                value = country.population.toString()
            )
        )
        adapter.submitList(list)
    }

    /*
     * Method that launches a coroutine and performs the delete query for the specific country.
     */

    fun delete(country: Country) {
        viewModelScope.launch(Dispatchers.IO) {
            localDb.delete(country)
            _countryDeleted.postValue(true)
        }
    }
}
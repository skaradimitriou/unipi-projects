package com.stathis.secondassignment.ui.main.landing

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.stathis.secondassignment.abstraction.BaseViewModel
import com.stathis.secondassignment.callback.CountryCallback
import com.stathis.secondassignment.db.CountriesDatabase
import com.stathis.secondassignment.model.Country
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class CountriesLandingViewModel(app: Application) : BaseViewModel(app), CountryCallback {

    private val localDb by lazy { CountriesDatabase.getDatabase(app).countriesDao() }

    /**
     * [Flow] that contains the value of the countries that are saved in the localDb.
     */
    private val countries: Flow<List<Country>>
        get() = localDb.getAllCountries()

    /**
     * [LiveData] that contains the size of the countries that are saved in the localDb.
     */
    val countryCount: LiveData<Int>
        get() = _countryCount

    private val _countryCount = MutableLiveData(0)

    /**
     * [LiveData] that notifies about the deletion of a country.
     */

    val countryDeleted: LiveData<Boolean>
        get() = _countryDeleted

    private val _countryDeleted = MutableLiveData(false)

    val adapter = CountriesAdapter(this)

    private lateinit var callback: CountryCallback

    fun setListener(callback: CountryCallback) {
        this.callback = callback
    }

    /*
     * Method that launches a coroutine and collects the data that are saved in the localDb.
     */

    fun getData() {
        viewModelScope.launch(Dispatchers.IO) {
            countries.collect { list ->
                adapter.submitList(list)
                _countryCount.postValue(list.size)
            }
        }
    }

    /*
     * Method that launches a coroutine and performs the searchByName query to localDb.
     */

    fun filterCountries(query: String) {
        viewModelScope.launch(Dispatchers.IO) {
            localDb.searchCountriesByName(countryName = "%$query%").collect { list ->
                adapter.submitList(list)
                _countryCount.postValue(list.size)
            }
        }
    }

    /*
     * Method that launches a coroutine and performs the delete query for the specific country.
     */

    fun deleteCountry(country: Country) {
        viewModelScope.launch(Dispatchers.IO) {
            localDb.delete(country)
            _countryDeleted.postValue(true)
        }
    }

    /**
     * Callback that the country item has been clicked in the UI layer
     */

    override fun onCountryClick(country: Country) = callback.onCountryClick(country)

    /**
     * Callback that the edit icon has been clicked in the UI layer
     */

    override fun onEditIconClick(country: Country) = callback.onEditIconClick(country)

    /**
     * Callback that the delete icon has been clicked in the UI layer
     */

    override fun onDeleteIconClick(country: Country) = callback.onDeleteIconClick(country)

    /**
     * Helper method that resets the values of the livedata in the viewModel
     * when navigating to other screens.
     */

    fun reset() {
        _countryDeleted.postValue(false)
    }
}
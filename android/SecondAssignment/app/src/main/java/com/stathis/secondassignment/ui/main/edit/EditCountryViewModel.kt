package com.stathis.secondassignment.ui.main.edit

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.stathis.secondassignment.abstraction.BaseViewModel
import com.stathis.secondassignment.db.CountriesDatabase
import com.stathis.secondassignment.model.Country
import com.stathis.secondassignment.utils.EMPTY_STRING
import com.stathis.secondassignment.utils.ZERO_LONG
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class EditCountryViewModel(app: Application) : BaseViewModel(app) {

    private val localDb by lazy { CountriesDatabase.getDatabase(app).countriesDao() }

    /**
     * Livedata that is triggered on successful country update in localDb.
     */

    val countryUpdated: LiveData<Boolean>
        get() = _countryUpdated

    private val _countryUpdated = MutableLiveData(false)

    /**
     * Livedata that notifies about the state (enabled/disabled) of the button
     * according to what the user has typed inside the editTexts in the UI Layer.
     */

    val buttonState: LiveData<Boolean>
        get() = _buttonState

    private val _buttonState = MutableLiveData(false)

    /**
     * Helper variables to store the input of the UI layer's editTexts.
     */
    var name: String = EMPTY_STRING
    var capital: String = EMPTY_STRING
    var population: Long = ZERO_LONG

    fun validateInput() {
        if (name.isEmpty() || capital.isEmpty() || population == ZERO_LONG) {
            _buttonState.postValue(false)
        } else {
            _buttonState.postValue(true)
        }
    }

    /*
     * Updates country to local Db
     */

    fun updateCountryToDb(country: Country) {
        val newCountry = Country(country.id, name, capital, population)
        viewModelScope.launch(Dispatchers.IO) {
            localDb.update(newCountry)
            _countryUpdated.postValue(true)
        }
    }
}
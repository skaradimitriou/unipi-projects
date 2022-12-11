package com.stathis.secondassignment.callback

import com.stathis.secondassignment.model.Country

/**
 * Interface that is used in CountriesLandingFragment to get the user reaction while taping
 * in certain areas of the countries item.
 */
interface CountryCallback {
    fun onCountryClick(country: Country)
    fun onEditIconClick(country: Country)
    fun onDeleteIconClick(country: Country)
}
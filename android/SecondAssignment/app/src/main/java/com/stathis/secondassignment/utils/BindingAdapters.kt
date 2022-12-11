package com.stathis.secondassignment.utils

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.stathis.secondassignment.R
import com.stathis.secondassignment.model.Country
import java.util.*

/**
 * Helper file to organize binding adapters in a single place
 */

@BindingAdapter("setCountryName")
fun TextView.setCountryName(country: Country) {
    text = country.name
}

@BindingAdapter("setCapital")
fun TextView.setCapital(country: Country) {
    text = resources.getString(R.string.capital_placeholder, country.capital)
}

@BindingAdapter("setLocalImage")
fun ImageView.setLocalImage(resourceId: Int) {
    try {
        setImageResource(resourceId)
    } catch (e: Exception) {
        setImageResource(R.mipmap.ic_countries_logo)
    }
}

@BindingAdapter("setPopulation")
fun TextView.setPopulation(population: Long) {
    text = try {
        val format = "%".format(Locale.ENGLISH, population)
        resources.getString(R.string.population_placeholder, format)
    } catch (e: Exception) {
        resources.getString(R.string.population_placeholder, population.toString())
    }
}
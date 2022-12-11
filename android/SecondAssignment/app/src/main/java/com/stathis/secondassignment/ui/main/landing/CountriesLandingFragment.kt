package com.stathis.secondassignment.ui.main.landing

import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.core.view.MenuProvider
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.stathis.secondassignment.R
import com.stathis.secondassignment.abstraction.BaseFragment
import com.stathis.secondassignment.callback.CountryCallback
import com.stathis.secondassignment.databinding.FragmentCountriesLandingBinding
import com.stathis.secondassignment.model.Country
import com.stathis.secondassignment.utils.*

class CountriesLandingFragment :
    BaseFragment<FragmentCountriesLandingBinding>(R.layout.fragment_countries_landing),
    MenuProvider {

    private val viewModel: CountriesLandingViewModel by viewModels()

    override fun init() {
        setScreenTitle(getString(R.string.landing_title))
        setMenuProvider(this)
        binding.viewModel = viewModel
        binding.emptyResults = false
    }

    override fun startOps() {
        viewModel.getData()

        binding.addNewCountryFabBtn.setOnClickListener {
            goToCountryAdditionScreen()
        }

        viewModel.setListener(object : CountryCallback {
            override fun onCountryClick(country: Country) {
                withDelay(DEFAULT_DELAY) { goToDetailsScreen(country) }
            }

            override fun onEditIconClick(country: Country) = goToCountryEditScreen(country)
            override fun onDeleteIconClick(country: Country) {
                showCountryDeletionDialog {
                    viewModel.deleteCountry(country)
                }
            }
        })

        viewModel.countryCount.observe(viewLifecycleOwner) { count ->
            binding.emptyResults = count <= ZERO
            withDelay(DEFAULT_DELAY) {
                binding.countriesRecycler.scrollToPosition(ZERO)
            }
        }

        viewModel.countryDeleted.observe(viewLifecycleOwner) { deleted ->
            if (deleted) showSnackbar(getString(R.string.successful_country_deletion))
        }
    }

    override fun stopOps() {
        viewModel.reset()
    }

    override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
        menuInflater.inflate(R.menu.landing_menu, menu)

        val item: MenuItem? = menu.findItem(R.id.search_action)
        val searchView = item?.actionView as androidx.appcompat.widget.SearchView
        searchView.queryHint = resources.getString(R.string.search_menu_item)

        searchView.onQueryTextChanged { query ->
            if (query.isNullOrEmpty()) {
                viewModel.getData()
            } else {
                viewModel.filterCountries(query = query)
            }
        }
    }

    override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
        return false
    }

    private fun goToDetailsScreen(country: Country) {
        val action = CountriesLandingFragmentDirections.goToCountryDetailsScreen(country)
        findNavController().navigate(action)
    }

    private fun goToCountryEditScreen(country: Country) {
        val action = CountriesLandingFragmentDirections.goToCountryEditScreen(country)
        findNavController().navigate(action)
    }

    private fun goToCountryAdditionScreen() {
        val action = CountriesLandingFragmentDirections.goToCountryAdditionScreen()
        findNavController().navigate(action)
    }
}
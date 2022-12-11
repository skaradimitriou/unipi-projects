package com.stathis.secondassignment.ui.main.details

import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.core.view.MenuProvider
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.stathis.secondassignment.R
import com.stathis.secondassignment.abstraction.BaseFragment
import com.stathis.secondassignment.databinding.FragmentCountryDetailsBinding
import com.stathis.secondassignment.utils.ZERO
import com.stathis.secondassignment.utils.setMenuProvider
import com.stathis.secondassignment.utils.setScreenTitle
import com.stathis.secondassignment.utils.showCountryDeletionDialog


class CountryDetailsFragment :
    BaseFragment<FragmentCountryDetailsBinding>(R.layout.fragment_country_details), MenuProvider {

    private val viewModel: CountryDetailsViewModel by viewModels()

    private val args: CountryDetailsFragmentArgs by navArgs()

    override fun init() {
        setScreenTitle(getString(R.string.details_screen_title))
        setMenuProvider(this)
        binding.viewModel = viewModel
    }

    override fun startOps() {
        viewModel.getCountryDetails(args.country.id ?: ZERO)

        viewModel.countryDeleted.observe(viewLifecycleOwner) { deletedSuccessfuly ->
            if (deletedSuccessfuly) findNavController().popBackStack()
        }
    }

    override fun stopOps() {}

    override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
        menuInflater.inflate(R.menu.details_menu, menu)
    }

    override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
        when (menuItem.itemId) {
            R.id.details_edit -> goToEditScreen()
            R.id.details_delete -> {
                showCountryDeletionDialog {
                    viewModel.delete(country = args.country)
                }
            }
        }
        return false
    }

    private fun goToEditScreen() {
        val action = CountryDetailsFragmentDirections.goToCountryEditScreen(args.country)
        findNavController().navigate(action)
    }
}
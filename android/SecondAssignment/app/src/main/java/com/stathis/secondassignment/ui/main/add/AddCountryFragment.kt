package com.stathis.secondassignment.ui.main.add

import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.core.view.MenuProvider
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.stathis.secondassignment.R
import com.stathis.secondassignment.abstraction.BaseFragment
import com.stathis.secondassignment.databinding.FragmentAddCountryBinding
import com.stathis.secondassignment.utils.*

class AddCountryFragment : BaseFragment<FragmentAddCountryBinding>(R.layout.fragment_add_country),
    MenuProvider {

    private val viewModel: AddCountryViewModel by viewModels()

    override fun init() {
        setScreenTitle(getString(R.string.add_country_title))
        setMenuProvider(this)
    }

    override fun startOps() {
        binding.countryNameInputField.afterTextChanged { input ->
            viewModel.name = input ?: EMPTY_STRING
            viewModel.validateInput()
        }

        binding.countryCapitalInputField.afterTextChanged { input ->
            viewModel.capital = input ?: EMPTY_STRING
            viewModel.validateInput()
        }

        binding.populationInputField.afterTextChanged { input ->
            viewModel.population = input?.toLongOrNull() ?: ZERO_LONG
            viewModel.validateInput()
        }

        binding.saveCountryBtn.setOnClickListener {
            viewModel.insertCountryToDb()
        }

        viewModel.countrySaved.observe(viewLifecycleOwner) { savedSuccessfuly ->
            if (savedSuccessfuly) findNavController().popBackStack()
        }

        viewModel.buttonState.observe(viewLifecycleOwner) { enabled ->
            binding.buttonEnabled = enabled
        }
    }

    override fun stopOps() {}

    override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
        menuInflater.inflate(R.menu.add_country_menu, menu)
    }

    override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
        when (menuItem.itemId) {
            R.id.info_icon -> {
                showAlertDialog(
                    title = getString(R.string.new_country),
                    message = getString(R.string.add_country_info_message)
                )
            }
        }
        return false
    }
}
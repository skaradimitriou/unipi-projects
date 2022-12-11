package com.stathis.secondassignment.ui.main.edit

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.stathis.secondassignment.R
import com.stathis.secondassignment.abstraction.BaseFragment
import com.stathis.secondassignment.databinding.FragmentEditBinding
import com.stathis.secondassignment.utils.*

class EditCountryFragment : BaseFragment<FragmentEditBinding>(R.layout.fragment_edit) {

    private val viewModel: EditCountryViewModel by viewModels()

    private val args: EditCountryFragmentArgs by navArgs()

    override fun init() {
        setScreenTitle(getString(R.string.edit_country_header))
    }

    override fun startOps() {
        binding.countryNameInputField.apply {
            afterTextChanged { input ->
                viewModel.name = input ?: EMPTY_STRING
                viewModel.validateInput()
            }
            applyText(args.country.name)
        }

        binding.countryCapitalInputField.apply {
            afterTextChanged { input ->
                viewModel.capital = input ?: EMPTY_STRING
                viewModel.validateInput()
            }
            applyText(args.country.capital)
        }

        binding.populationInputField.apply {
            afterTextChanged { input ->
                viewModel.population = input?.toLongOrNull() ?: ZERO_LONG
                viewModel.validateInput()
            }
            applyText(args.country.population.toString())
        }

        binding.saveCountryBtn.setOnClickListener {
            viewModel.updateCountryToDb(args.country)
        }

        viewModel.countryUpdated.observe(viewLifecycleOwner) { savedSuccessfuly ->
            if (savedSuccessfuly) findNavController().popBackStack()
        }

        viewModel.buttonState.observe(viewLifecycleOwner) { enabled ->
            binding.buttonEnabled = enabled
        }
    }

    override fun stopOps() {}
}
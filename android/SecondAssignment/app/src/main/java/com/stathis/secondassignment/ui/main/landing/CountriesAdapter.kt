package com.stathis.secondassignment.ui.main.landing

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.stathis.secondassignment.abstraction.DiffUtilClass
import com.stathis.secondassignment.abstraction.UiModel
import com.stathis.secondassignment.callback.CountryCallback
import com.stathis.secondassignment.databinding.HolderCountryItemBinding
import com.stathis.secondassignment.model.Country

class CountriesAdapter(private val callback: CountryCallback) :
    ListAdapter<UiModel, CountriesViewHolder>(DiffUtilClass<UiModel>()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountriesViewHolder {
        val view = HolderCountryItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CountriesViewHolder(view, callback)
    }

    override fun onBindViewHolder(holder: CountriesViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class CountriesViewHolder(
    private val binding: HolderCountryItemBinding,
    private val callback: CountryCallback
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(model: UiModel) = when (model) {
        is Country -> {
            binding.country = model
            binding.callback = callback
        }
        else -> Unit
    }
}
package com.stathis.secondassignment.ui.main.details

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.stathis.secondassignment.abstraction.DiffUtilClass
import com.stathis.secondassignment.abstraction.UiModel
import com.stathis.secondassignment.databinding.HolderCountryDetailItemBinding
import com.stathis.secondassignment.model.CountryDetail

class CountryDetailsAdapter() :
    ListAdapter<UiModel, CountriesViewHolder>(DiffUtilClass<UiModel>()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountriesViewHolder {
        val view = HolderCountryDetailItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CountriesViewHolder(view)
    }

    override fun onBindViewHolder(holder: CountriesViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class CountriesViewHolder(
    private val binding: HolderCountryDetailItemBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(model: UiModel) = when (model) {
        is CountryDetail -> binding.detail = model
        else -> Unit
    }
}
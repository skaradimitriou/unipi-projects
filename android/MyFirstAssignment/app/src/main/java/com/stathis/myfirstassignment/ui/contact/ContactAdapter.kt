package com.stathis.myfirstassignment.ui.contact

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.stathis.myfirstassignment.abstraction.DiffUtilClass
import com.stathis.myfirstassignment.databinding.HolderContactItemBinding
import com.stathis.myfirstassignment.model.ContactModel

class ContactAdapter() :
    ListAdapter<ContactModel, ContactViewHolder>(DiffUtilClass<ContactModel>()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = HolderContactItemBinding.inflate(inflater, parent, false)
        return ContactViewHolder(view)
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}


class ContactViewHolder(
    private val binding: HolderContactItemBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(model: ContactModel) {
        binding.model = model
    }
}
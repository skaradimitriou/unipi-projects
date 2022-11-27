package com.stathis.myfirstassignment.ui.intro

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.stathis.myfirstassignment.abstraction.DiffUtilClass
import com.stathis.myfirstassignment.callback.DashboardClickListener
import com.stathis.myfirstassignment.databinding.HolderDashboardItemBinding
import com.stathis.myfirstassignment.model.DashboardItem

class IntroAdapter(private val callback: DashboardClickListener) :
    ListAdapter<DashboardItem, IntroViewHolder>(DiffUtilClass<DashboardItem>()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IntroViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = HolderDashboardItemBinding.inflate(inflater, parent, false)
        return IntroViewHolder(view, callback)
    }

    override fun onBindViewHolder(holder: IntroViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class IntroViewHolder(
    private val binding: HolderDashboardItemBinding,
    private val callback: DashboardClickListener
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(model: DashboardItem) {
        binding.model = model

        binding.root.setOnClickListener {
            callback.onDashboardItemClick(model)
        }
    }
}
package com.stathis.secondassignment.abstraction

import androidx.recyclerview.widget.DiffUtil

class DiffUtilClass<T : UiModel> : DiffUtil.ItemCallback<T>() {

    override fun areItemsTheSame(oldItem: T, newItem: T): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: T, newItem: T): Boolean {
        return oldItem.equals(newItem)
    }
}
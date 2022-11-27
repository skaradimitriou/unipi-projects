package com.stathis.myfirstassignment.abstraction

import androidx.recyclerview.widget.DiffUtil

/**
 * Diff Util Class for all the List Adapters inside the project.
 */
class DiffUtilClass<T : UiModel> : DiffUtil.ItemCallback<T>() {
    override fun areItemsTheSame(oldItem: T, newItem: T): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: T, newItem: T): Boolean {
        return oldItem.equalsContent(newItem)
    }
}
package com.stathis.myfirstassignment.ui.lessons

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.stathis.myfirstassignment.abstraction.DiffUtilClass
import com.stathis.myfirstassignment.databinding.HolderLessonItemBinding
import com.stathis.myfirstassignment.model.Lesson

class LessonsAdapter() : ListAdapter<Lesson, LessonsViewHolder>(DiffUtilClass<Lesson>()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LessonsViewHolder {
        val view = HolderLessonItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return LessonsViewHolder(view)
    }

    override fun onBindViewHolder(holder: LessonsViewHolder, position: Int) {
        holder.present(getItem(position))
    }
}

class LessonsViewHolder(val binding: HolderLessonItemBinding) : RecyclerView.ViewHolder(binding.root) {

    fun present(model: Lesson) {
        binding.model = model
    }
}
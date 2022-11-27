package com.stathis.myfirstassignment.ui.syllabus

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.stathis.myfirstassignment.abstraction.DiffUtilClass
import com.stathis.myfirstassignment.callback.SemesterCallback
import com.stathis.myfirstassignment.databinding.HolderSemesterItemBinding
import com.stathis.myfirstassignment.model.Semester

class SyllabusAdapter(val callback: SemesterCallback) :
    ListAdapter<Semester, SyllabusViewHolder>(DiffUtilClass<Semester>()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SyllabusViewHolder {
        val view = HolderSemesterItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SyllabusViewHolder(view, callback)
    }

    override fun onBindViewHolder(holder: SyllabusViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class SyllabusViewHolder(
    private val binding: HolderSemesterItemBinding,
    private val callback: SemesterCallback
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(model: Semester) {
        binding.model = model

        binding.root.setOnClickListener {
            callback.onSemesterTap(model)
        }
    }
}
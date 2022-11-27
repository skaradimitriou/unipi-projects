package com.stathis.myfirstassignment.ui.lessons

import android.app.Application
import com.stathis.myfirstassignment.abstraction.BaseViewModel
import com.stathis.myfirstassignment.model.Lesson

class LessonsViewModel(val app: Application) : BaseViewModel(app) {

    val adapter = LessonsAdapter()

    fun getData(data: List<Lesson>) {
        adapter.submitList(data)
    }
}
package com.stathis.myfirstassignment.ui.syllabus

import android.app.Application
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.stathis.myfirstassignment.abstraction.BaseViewModel
import com.stathis.myfirstassignment.callback.SemesterCallback
import com.stathis.myfirstassignment.model.Semester
import com.stathis.myfirstassignment.util.SEMESTERS
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SyllabusViewModel(val app: Application) : BaseViewModel(app), SemesterCallback {

    val adapter = SyllabusAdapter(this)

    private val semesters: LiveData<List<Semester>>
        get() = _semesters

    private val _semesters = MutableLiveData<List<Semester>>(listOf())
    private lateinit var callback: SemesterCallback

    init {
        getData()
    }

    private fun getData() {
        viewModelScope.launch(Dispatchers.IO) {
            getSemesters()
        }
    }

    private fun getSemesters() {
        try {
            val jsonString = app.assets.open(SEMESTERS).bufferedReader()
                .use { it.readText() }
            val listPersonType = object : TypeToken<List<Semester>>() {}.type
            val semesterList: MutableList<Semester> = Gson().fromJson(jsonString, listPersonType)
            _semesters.postValue(semesterList)
        } catch (e: Exception) {
            _semesters.postValue(listOf())
        }
    }

    fun observe(owner: LifecycleOwner, callback: SemesterCallback) {
        this.callback = callback
        semesters.observe(owner) {
            adapter.submitList(it)
        }
    }

    override fun onSemesterTap(model: Semester) = callback.onSemesterTap(model)
}
package com.stathis.myfirstassignment.ui.lessons

import android.view.MenuItem
import androidx.activity.viewModels
import com.google.gson.Gson
import com.stathis.myfirstassignment.R
import com.stathis.myfirstassignment.abstraction.BaseActivity
import com.stathis.myfirstassignment.databinding.ActivityLessonsBinding
import com.stathis.myfirstassignment.model.Semester
import com.stathis.myfirstassignment.util.SEMESTER
import com.stathis.myfirstassignment.util.setScreenTitle

class LessonsActivity : BaseActivity<ActivityLessonsBinding>(R.layout.activity_lessons) {

    private val viewModel: LessonsViewModel by viewModels { defaultViewModelProviderFactory }

    override fun init() {
        binding.viewModel = viewModel
    }

    override fun startOps() {
        val model = intent.getStringExtra(SEMESTER)

        model?.let { json ->
            val semester = Gson().fromJson(json, Semester::class.java)
            setScreenTitle(semester.title)
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
            viewModel.getData(semester.lessons)
        }
    }

    override fun stopOps() {}

    override fun onOptionsItemSelected(item: MenuItem): Boolean = when (item.itemId) {
        android.R.id.home -> {
            onBackPressed()
            true
        }

        else -> false
    }
}
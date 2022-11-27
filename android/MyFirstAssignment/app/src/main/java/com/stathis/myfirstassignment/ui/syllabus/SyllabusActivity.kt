package com.stathis.myfirstassignment.ui.syllabus

import android.content.Intent
import android.view.MenuItem
import androidx.activity.viewModels
import com.google.gson.Gson
import com.stathis.myfirstassignment.R
import com.stathis.myfirstassignment.abstraction.BaseActivity
import com.stathis.myfirstassignment.databinding.ActivitySyllabusBinding
import com.stathis.myfirstassignment.model.Semester
import com.stathis.myfirstassignment.ui.lessons.LessonsActivity
import com.stathis.myfirstassignment.util.SEMESTER
import com.stathis.myfirstassignment.util.setScreenTitle

class SyllabusActivity : BaseActivity<ActivitySyllabusBinding>(R.layout.activity_syllabus) {

    private val viewModel: SyllabusViewModel by viewModels { defaultViewModelProviderFactory }

    override fun init() {
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        setScreenTitle(getString(R.string.syllabus))
        binding.viewModel = viewModel
    }

    override fun startOps() {
        viewModel.observe(this) { semester ->
            goToLessonsScreen(semester)
        }
    }

    override fun stopOps() {}

    private fun goToLessonsScreen(model: Semester) {
        val intent = Intent(this, LessonsActivity::class.java).apply {
            val json = Gson().toJson(model)
            putExtra(SEMESTER, json)
        }

        startActivity(intent)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean = when (item.itemId) {
        android.R.id.home -> {
            onBackPressed()
            true
        }

        else -> false
    }
}
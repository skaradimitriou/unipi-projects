package com.stathis.myfirstassignment.ui.presentation

import android.view.MenuItem
import com.stathis.myfirstassignment.R
import com.stathis.myfirstassignment.abstraction.BaseActivity
import com.stathis.myfirstassignment.databinding.ActivityPresentationBinding
import com.stathis.myfirstassignment.util.setScreenTitle

class PresentationActivity :
    BaseActivity<ActivityPresentationBinding>(R.layout.activity_presentation) {

    override fun init() {
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        setScreenTitle(getString(R.string.quick_presentation_title))
    }

    override fun startOps() {}
    override fun stopOps() {}

    override fun onOptionsItemSelected(item: MenuItem): Boolean = when (item.itemId) {
        android.R.id.home -> {
            onBackPressed()
            true
        }

        else -> false
    }
}
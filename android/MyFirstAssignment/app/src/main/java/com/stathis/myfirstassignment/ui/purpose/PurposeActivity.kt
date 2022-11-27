package com.stathis.myfirstassignment.ui.purpose

import android.view.MenuItem
import com.stathis.myfirstassignment.R
import com.stathis.myfirstassignment.abstraction.BaseActivity
import com.stathis.myfirstassignment.databinding.ActivityPurposeBinding
import com.stathis.myfirstassignment.util.setScreenTitle

class PurposeActivity : BaseActivity<ActivityPurposeBinding>(R.layout.activity_purpose) {

    override fun init() {
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        setScreenTitle(getString(R.string.purpose_title))
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
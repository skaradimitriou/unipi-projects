package com.stathis.myfirstassignment.ui.contact

import android.view.MenuItem
import androidx.activity.viewModels
import com.stathis.myfirstassignment.R
import com.stathis.myfirstassignment.abstraction.BaseActivity
import com.stathis.myfirstassignment.databinding.ActivityContactBinding
import com.stathis.myfirstassignment.util.setScreenTitle

class ContactActivity : BaseActivity<ActivityContactBinding>(R.layout.activity_contact) {

    private val viewModel: ContactViewModel by viewModels { defaultViewModelProviderFactory }

    override fun init() {
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        setScreenTitle(getString(R.string.contact))
        binding.viewModel = viewModel
    }

    override fun startOps() {
        viewModel.observe(this)
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
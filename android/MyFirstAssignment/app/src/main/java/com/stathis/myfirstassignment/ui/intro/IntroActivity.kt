package com.stathis.myfirstassignment.ui.intro

import android.content.Intent
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import com.google.android.material.navigation.NavigationView
import com.stathis.myfirstassignment.R
import com.stathis.myfirstassignment.abstraction.BaseActivity
import com.stathis.myfirstassignment.databinding.ActivityIntroBinding
import com.stathis.myfirstassignment.ui.contact.ContactActivity
import com.stathis.myfirstassignment.ui.presentation.PresentationActivity
import com.stathis.myfirstassignment.ui.purpose.PurposeActivity
import com.stathis.myfirstassignment.ui.syllabus.SyllabusActivity
import com.stathis.myfirstassignment.util.setScreenTitle

class IntroActivity : BaseActivity<ActivityIntroBinding>(R.layout.activity_intro), NavigationView.OnNavigationItemSelectedListener {

    private val viewModel: IntroViewModel by viewModels { defaultViewModelProviderFactory }
    private lateinit var toggle: ActionBarDrawerToggle

    override fun init() {
        binding.viewModel = viewModel
        setScreenTitle(getString(R.string.intro_title))

        toggle = ActionBarDrawerToggle(this, binding.drawerLayout, R.string.open, R.string.close)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        binding.drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        binding.drawerMenu.setNavigationItemSelectedListener(this)
    }

    override fun startOps() {
        viewModel.observe(this) { selectedItem ->
            when (selectedItem.title) {
                getString(R.string.presentation) -> {
                    startActivity(Intent(this, PresentationActivity::class.java))
                }
                getString(R.string.purpose) -> {
                    startActivity(Intent(this, PurposeActivity::class.java))
                }
                getString(R.string.syllabus) -> {
                    startActivity(Intent(this, SyllabusActivity::class.java))
                }
                getString(R.string.contact) -> {
                    startActivity(Intent(this, ContactActivity::class.java))
                }
            }
        }
    }

    override fun stopOps() {}

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (binding.drawerLayout.isOpen) {
            true -> binding.drawerLayout.closeDrawer(GravityCompat.START)
            false -> binding.drawerLayout.openDrawer(GravityCompat.START)
        }
        return true
    }


    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_presentation -> {
                startActivity(Intent(this, PresentationActivity::class.java))
                binding.drawerLayout.closeDrawer(GravityCompat.START)
            }

            R.id.nav_purpose -> {
                startActivity(Intent(this, PurposeActivity::class.java))
                binding.drawerLayout.closeDrawer(GravityCompat.START)
            }

            R.id.nav_syllabus -> {
                startActivity(Intent(this, SyllabusActivity::class.java))
                binding.drawerLayout.closeDrawer(GravityCompat.START)
            }

            R.id.nav_contact -> {
                startActivity(Intent(this, ContactActivity::class.java))
                binding.drawerLayout.closeDrawer(GravityCompat.START)
            }
        }
        return true
    }
}
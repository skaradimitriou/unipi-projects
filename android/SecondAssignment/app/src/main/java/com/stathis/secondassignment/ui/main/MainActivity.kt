package com.stathis.secondassignment.ui.main

import android.view.MenuItem
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.stathis.secondassignment.R
import com.stathis.secondassignment.abstraction.BaseActivity
import com.stathis.secondassignment.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {

    private lateinit var navController: NavController

    override fun init() {
        navController = findNavController(R.id.nav_host_fragment)
    }

    override fun startOps() {
        navController.addOnDestinationChangedListener { _, destination, _ ->
            val isLandingVisible = destination.id == R.id.countriesLandingFragment
            supportActionBar?.setDisplayHomeAsUpEnabled(!isLandingVisible)
        }
    }

    override fun stopOps() {}

    override fun onOptionsItemSelected(item: MenuItem): Boolean = when (item.itemId) {
        android.R.id.home -> {
            if (navController.graph.startDestinationId == navController.currentDestination?.id) {
                finish()
            } else {
                navController.popBackStack()
            }
            true
        }
        else -> false
    }
}
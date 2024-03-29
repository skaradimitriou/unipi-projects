package com.stathis.secondassignment.abstraction

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

abstract class BaseActivity<VB : ViewDataBinding>(val layoutId: Int) : AppCompatActivity() {

    lateinit var binding: VB

    abstract fun init()
    abstract fun startOps()
    abstract fun stopOps()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, layoutId)
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        init()
    }

    override fun onPostResume() {
        super.onPostResume()
        startOps()
    }

    override fun onStop() {
        stopOps()
        super.onStop()
    }
}
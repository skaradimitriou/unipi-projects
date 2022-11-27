package com.stathis.myfirstassignment.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.stathis.myfirstassignment.R
import java.lang.Exception

/**
 * Helper file to organize binding adapters user across project
 */

@BindingAdapter("setLocalImgRes")
fun ImageView.setLocalImgRes(idRes : Int) {
    try {
        setImageResource(idRes)
    } catch (e : Exception) {
        setImageResource(R.mipmap.unipi_logo)
    }
}
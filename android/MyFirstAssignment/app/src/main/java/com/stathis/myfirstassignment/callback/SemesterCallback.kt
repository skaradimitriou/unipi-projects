package com.stathis.myfirstassignment.callback

import com.stathis.myfirstassignment.model.Semester

fun interface SemesterCallback {
    fun onSemesterTap(model : Semester)
}
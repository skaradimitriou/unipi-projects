package com.stathis.myfirstassignment.callback

import com.stathis.myfirstassignment.model.DashboardItem

fun interface DashboardClickListener {
    fun onDashboardItemClick(model : DashboardItem)
}
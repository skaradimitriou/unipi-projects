package com.stathis.myfirstassignment.model

import com.stathis.myfirstassignment.abstraction.UiModel

/**
 * Model used in Dashboard Activity for basic navigation options.
 */

data class DashboardItem(
    val title: String,
    val imageRes: Int
) : UiModel {
    override fun equalsContent(obj: UiModel): Boolean = when (obj) {
        is DashboardItem -> title == obj.title && imageRes == obj.imageRes
        else -> false
    }
}
package com.stathis.myfirstassignment.model

import com.stathis.myfirstassignment.abstraction.UiModel

data class Lesson(
    val title: String,
    val code: String,
    val mandatory: Boolean,
    val hours: Int,
    val ects: Int,
    val description: String,
    var isExpanded: Boolean = false
) : UiModel {
    override fun equalsContent(obj: UiModel): Boolean = when (obj) {
        is Lesson -> title == obj.title && code == obj.code
        else -> false
    }
}

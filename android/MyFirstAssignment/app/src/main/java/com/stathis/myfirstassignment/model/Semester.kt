package com.stathis.myfirstassignment.model

import com.stathis.myfirstassignment.abstraction.UiModel

data class Semester(
    val title : String,
    val information : String,
    val lessons : List<Lesson>

) : UiModel {
    override fun equalsContent(obj: UiModel): Boolean = when(obj){
        is Semester -> false
        else -> false
    }
}

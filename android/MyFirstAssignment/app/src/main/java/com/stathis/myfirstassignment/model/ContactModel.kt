package com.stathis.myfirstassignment.model

import com.stathis.myfirstassignment.abstraction.UiModel

data class ContactModel(
    val title: String,
    val address: String,
    val telephone: String,
    val email: String,
    val imageRes: Int
) : UiModel {
    override fun equalsContent(obj: UiModel): Boolean = when (obj) {
        is ContactModel -> title == obj.title && imageRes == obj.imageRes
        else -> false
    }
}

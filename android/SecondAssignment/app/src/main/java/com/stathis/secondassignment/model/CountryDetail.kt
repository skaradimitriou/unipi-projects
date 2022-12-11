package com.stathis.secondassignment.model

import com.stathis.secondassignment.abstraction.UiModel

data class CountryDetail(
    val image: Int,
    val title: String,
    val value: String
) : UiModel {
    override fun equals(obj: UiModel): Boolean = when (obj) {
        is CountryDetail -> image == obj.image && title == obj.title && value == obj.value
        else -> false
    }
}

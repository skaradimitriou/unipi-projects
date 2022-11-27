package com.stathis.myfirstassignment.abstraction

/**
 * Abstract model that is implemented by all models in the application.
 */

interface UiModel {
    fun equalsContent(obj: UiModel): Boolean
}
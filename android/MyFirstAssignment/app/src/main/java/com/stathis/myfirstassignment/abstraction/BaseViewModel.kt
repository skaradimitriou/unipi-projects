package com.stathis.myfirstassignment.abstraction

import android.app.Application
import androidx.lifecycle.AndroidViewModel

abstract class BaseViewModel(app: Application) : AndroidViewModel(app) {

    /**
     * Helper fun to get string resources from strings.xml file
     */
    fun getString(id: Int) = getApplication<Application>().resources.getString(id)
}
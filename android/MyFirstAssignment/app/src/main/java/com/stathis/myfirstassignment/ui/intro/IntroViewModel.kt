package com.stathis.myfirstassignment.ui.intro

import android.app.Application
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.stathis.myfirstassignment.R
import com.stathis.myfirstassignment.abstraction.BaseViewModel
import com.stathis.myfirstassignment.callback.DashboardClickListener
import com.stathis.myfirstassignment.model.DashboardItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class IntroViewModel(app: Application) : BaseViewModel(app), DashboardClickListener {

    val adapter = IntroAdapter(this)

    private val items: LiveData<List<DashboardItem>>
        get() = _items


    private val _items = MutableLiveData<List<DashboardItem>>(listOf())
    private lateinit var callback: DashboardClickListener

    init {
        viewModelScope.launch(Dispatchers.IO) {
            getList()
        }
    }

    private fun getList() {
        val list = listOf(
            DashboardItem(
                getString(R.string.presentation),
                R.drawable.ic_speaker
            ),
            DashboardItem(
                getString(R.string.purpose),
                R.drawable.ic_purpose
            ),
            DashboardItem(
                getString(R.string.syllabus),
                R.drawable.ic_books
            ),
            DashboardItem(
                getString(R.string.contact),
                R.drawable.ic_contact
            )
        )

        _items.postValue(list)
    }

    fun observe(owner: LifecycleOwner, callback: DashboardClickListener) {
        this.callback = callback
        items.observe(owner) {
            adapter.submitList(it)
        }
    }

    override fun onDashboardItemClick(model: DashboardItem) {
        callback.onDashboardItemClick(model)
    }
}
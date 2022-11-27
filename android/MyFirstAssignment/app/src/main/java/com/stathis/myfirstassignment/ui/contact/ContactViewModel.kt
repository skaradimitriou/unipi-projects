package com.stathis.myfirstassignment.ui.contact

import android.app.Application
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.stathis.myfirstassignment.R
import com.stathis.myfirstassignment.abstraction.BaseViewModel
import com.stathis.myfirstassignment.model.ContactModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ContactViewModel(val app: Application) : BaseViewModel(app) {

    val adapter = ContactAdapter()

    private val contactData: LiveData<List<ContactModel>>
        get() = _contactData

    private val _contactData: MutableLiveData<List<ContactModel>> =
        MutableLiveData<List<ContactModel>>(listOf())

    init {
        viewModelScope.launch(Dispatchers.IO) {
            getDummyList()
        }
    }

    private fun getDummyList() {
        val list = listOf(
            ContactModel(
                title = getString(R.string.unipi_secretary),
                address = getString(R.string.unipi_secretary_address),
                telephone = getString(R.string.unipi_secretary_tel),
                email = getString(R.string.unipi_secretary_email),
                imageRes = R.drawable.ic_contact
            ),
            ContactModel(
                title = getString(R.string.pms_secretary_title),
                address = getString(R.string.pms_secretary_address),
                telephone = getString(R.string.pms_secretary_tel),
                email = getString(R.string.pms_secretary_mail),
                imageRes = R.drawable.ic_contact
            ),
        )

        _contactData.postValue(list)
    }

    fun observe(owner: LifecycleOwner) {
        contactData.observe(owner) {
            adapter.submitList(it)
        }
    }
}
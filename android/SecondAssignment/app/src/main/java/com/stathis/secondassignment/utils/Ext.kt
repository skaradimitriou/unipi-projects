package com.stathis.secondassignment.utils

import android.text.Editable
import android.text.TextWatcher
import androidx.appcompat.widget.SearchView
import com.google.android.material.textfield.TextInputLayout

/**
 * Helper file to organize ext functions in the project.
 */

/**
 * Helper fun to simplify the [TextWatcher] afterTextChanged callback.
 */
fun TextInputLayout.afterTextChanged(inputText: (String?) -> Unit) {
    editText?.addTextChangedListener(object : TextWatcher {
        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
        override fun afterTextChanged(p0: Editable?) = inputText.invoke(p0?.toString())
    })
}

/**
 * Helper fun to setText in the [TextInputLayout]'s editText.
 */

fun TextInputLayout.applyText(text: String) {
    editText?.setText(text)
}

/**
 * Helper fun to simplify the [SearchView.OnQueryTextListener] onQueryTextChange method.
 */

fun SearchView.onQueryTextChanged(inputText: (String?) -> Unit) {
    setOnQueryTextListener(object : SearchView.OnQueryTextListener {
        override fun onQueryTextSubmit(p0: String?): Boolean = false
        override fun onQueryTextChange(query: String?): Boolean {
            inputText.invoke(query.toString())
            return false
        }
    })
}
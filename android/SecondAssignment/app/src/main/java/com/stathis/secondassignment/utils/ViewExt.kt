package com.stathis.secondassignment.utils

import android.app.AlertDialog
import android.view.LayoutInflater
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.snackbar.Snackbar
import com.stathis.secondassignment.databinding.DeleteCountryBottomsheetBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 * Helper method to simplify the ability to set a title inside a [Fragment] view.
 */

/**
 * Helper fun to set the [Fragment]'s title in a simple way.
 */

fun Fragment.setScreenTitle(title: String) {
    requireActivity().title = title
}

/**
 * Helper fun to show the custom bottomsheet for country deletion [DeleteCountryBottomsheetBinding].
 * There is a callback to get the primary button's callback.
 */

fun Fragment.showCountryDeletionDialog(onButtonClick: () -> Unit) {
    val binding = DeleteCountryBottomsheetBinding.inflate(LayoutInflater.from(requireContext()))
    val dialog = BottomSheetDialog(requireContext())
    dialog.setContentView(binding.root)

    binding.deleteBtn.setOnClickListener {
        onButtonClick.invoke()
        dialog.dismiss()
    }

    binding.notNowBtn.setOnClickListener {
        dialog.dismiss()
    }

    dialog.show()
}

/**
 * Helper fun to set [MenuProvider] in a simple way inside the [Fragment].
 */

fun Fragment.setMenuProvider(menuProvider: MenuProvider) {
    val menuHost: MenuHost = requireActivity()
    menuHost.addMenuProvider(menuProvider, viewLifecycleOwner, Lifecycle.State.RESUMED)
}


/**
 * Helper fun to show an [AlertDialog] inside the [Fragment].
 */

fun Fragment.showAlertDialog(title: String, message: String) {
    AlertDialog.Builder(requireContext())
        .setTitle(title)
        .setMessage(message)
        .show()
}

/**
 * Helper fun to show a [Snackbar] inside the [Fragment].
 */

fun Fragment.showSnackbar(message: String) {
    Snackbar.make(requireView(), message, Snackbar.LENGTH_LONG).show()
}

/**
 * Helper fun to create a custom delay inside the [Fragment].
 */

fun Fragment.withDelay(duration: Long, action: () -> Unit) {
    lifecycleScope.launch {
        delay(duration)
        action.invoke()
    }
}
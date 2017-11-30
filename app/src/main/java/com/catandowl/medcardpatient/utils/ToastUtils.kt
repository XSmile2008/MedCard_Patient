package com.catandowl.medcardpatient.utils

import android.content.Context
import android.support.annotation.StringRes
import android.widget.Toast
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by vladstarikov on 11/28/17.
 */
@Singleton
class ToastUtils @Inject constructor(private val context: Context) {

    fun showToast(@StringRes resId: Int) {
        Toast.makeText(context, resId, Toast.LENGTH_SHORT).show()
    }

    fun showToast(message: CharSequence) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

    fun showToastLong(@StringRes resId: Int) {
        Toast.makeText(context, resId, Toast.LENGTH_LONG).show()
    }

    fun showToastLong(message: CharSequence) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show()
    }
}
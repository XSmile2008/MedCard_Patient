package com.catandowl.medcardpatient.viewmodels

import android.arch.lifecycle.ViewModel
import android.databinding.ObservableField
import com.google.firebase.auth.FirebaseAuth
import javax.inject.Inject

/**
 * Created by vladstarikov on 11/27/17.
 */
class SignInViewModel(val auth: FirebaseAuth) : ViewModel() {

    val email: ObservableField<String> = ObservableField()
    val password: ObservableField<String> = ObservableField()

    init {
    }

    fun auth() {

    }
}
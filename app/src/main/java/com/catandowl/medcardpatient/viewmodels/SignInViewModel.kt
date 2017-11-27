package com.catandowl.medcardpatient.viewmodels

import android.arch.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import javax.inject.Inject

/**
 * Created by vladstarikov on 11/27/17.
 */
class SignInViewModel : ViewModel() {

    @Inject
    lateinit var auth: FirebaseAuth

    init {
        auth.currentUser//TODO:
    }

    fun auth() {

    }
}
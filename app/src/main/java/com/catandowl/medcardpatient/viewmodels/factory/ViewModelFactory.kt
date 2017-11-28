package com.catandowl.medcardpatient.viewmodels.factory

import android.app.Application
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.catandowl.medcardpatient.AppClass
import com.catandowl.medcardpatient.viewmodels.SignInViewModel
import com.catandowl.medcardpatient.viewmodels.SplashViewModel
import com.google.firebase.auth.FirebaseAuth
import javax.inject.Inject

/**
 * Created by vladstarikov on 11/28/17.
 */
class ViewModelFactory : ViewModelProvider.Factory {

    @Inject
    lateinit var application: Application

    @Inject
    lateinit var auth: FirebaseAuth

    init {
        AppClass.component.inject(this)
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T = when {
        modelClass.isAssignableFrom(SignInViewModel::class.java) -> SignInViewModel(auth) as T
        modelClass.isAssignableFrom(SplashViewModel::class.java) -> SplashViewModel(application, auth) as T
        else -> throw IllegalArgumentException("Unknown ViewModel class")
    }
}
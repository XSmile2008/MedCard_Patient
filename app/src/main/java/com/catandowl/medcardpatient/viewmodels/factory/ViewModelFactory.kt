package com.catandowl.medcardpatient.viewmodels.factory

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.catandowl.medcardpatient.viewmodels.*
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by vladstarikov on 11/28/17.
 */
@Singleton
class ViewModelFactory @Inject constructor(
        private val auth: FirebaseAuth,
        private val firestore: FirebaseFirestore
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T = when {
        modelClass.isAssignableFrom(MainViewModel::class.java) -> MainViewModel(auth) as T
        modelClass.isAssignableFrom(SignInViewModel::class.java) -> SignInViewModel(auth) as T
        modelClass.isAssignableFrom(SignUpViewModel::class.java) -> SignUpViewModel(auth) as T
        modelClass.isAssignableFrom(SplashViewModel::class.java) -> SplashViewModel(auth) as T
        modelClass.isAssignableFrom(DoctorsViewModel::class.java) -> DoctorsViewModel(firestore) as T
        else -> throw IllegalArgumentException("Unknown ViewModel class")
    }
}
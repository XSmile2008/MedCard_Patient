package com.catandowl.medcardpatient.viewmodels

import com.catandowl.medcardpatient.activities.MainActivity
import com.catandowl.medcardpatient.activities.SignInActivity
import com.catandowl.medcardpatient.events.NavigationEvent
import com.google.firebase.auth.FirebaseAuth

/**
 * Created by vladstarikov on 11/28/17.
 */
class SplashViewModel(private val auth: FirebaseAuth) : BaseViewModel() {

    init {
        checkAuth()
    }

    private fun checkAuth() = if (auth.currentUser == null) {
        navigation.postValue(NavigationEvent(SignInActivity::class.java))
    } else {
        navigation.postValue(NavigationEvent(MainActivity::class.java))
    }
}
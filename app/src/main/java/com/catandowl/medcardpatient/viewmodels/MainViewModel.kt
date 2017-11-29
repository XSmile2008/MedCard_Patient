package com.catandowl.medcardpatient.viewmodels

import com.catandowl.medcardpatient.activities.SignInActivity
import com.catandowl.medcardpatient.events.NavigationEvent
import com.google.firebase.auth.FirebaseAuth

/**
 * Created by vladstarikov on 11/29/17.
 */
class MainViewModel(val auth: FirebaseAuth) : BaseViewModel() {

    fun onLogoutAction() {
        auth.signOut()
        navigation.postValue(NavigationEvent(SignInActivity::class.java))
    }
}
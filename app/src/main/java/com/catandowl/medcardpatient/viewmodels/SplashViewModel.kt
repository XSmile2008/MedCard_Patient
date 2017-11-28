package com.catandowl.medcardpatient.viewmodels

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.content.Intent
import com.catandowl.medcardpatient.activities.MainActivity
import com.catandowl.medcardpatient.activities.SignInActivity
import com.google.firebase.auth.FirebaseAuth
import javax.inject.Inject

/**
 * Created by vladstarikov on 11/28/17.
 */
class SplashViewModel
@Inject constructor(
        app: Application,
        private val auth: FirebaseAuth
) : AndroidViewModel(app) {

    init {
        checkAuth()
    }

    private fun checkAuth() {
        if (auth.currentUser == null) {
            getApplication<Application>().startActivity(Intent(getApplication(), SignInActivity::class.java))
        } else {
            getApplication<Application>().startActivity(Intent(getApplication(), MainActivity::class.java))
        }
    }
}
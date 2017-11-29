package com.catandowl.medcardpatient.viewmodels

import android.databinding.ObservableField
import android.databinding.ObservableInt
import android.util.Log
import android.view.View
import com.catandowl.medcardpatient.activities.MainActivity
import com.catandowl.medcardpatient.activities.SignUpActivity
import com.catandowl.medcardpatient.events.NavigationEvent
import com.google.firebase.auth.FirebaseAuth

/**
 * Created by vladstarikov on 11/27/17.
 */
class SignInViewModel(val auth: FirebaseAuth) : BaseViewModel() {

    companion object {
        private val TAG = SignInViewModel::class.java.simpleName
    }

    val email = ObservableField<String>()
    val password = ObservableField<String>()
    val progressBarVisibility = ObservableInt(View.GONE)

    fun onSignInAction() {
        Log.d(javaClass.name, "onSignInAction: email = ${email.get()}, password = ${password.get()})")
        if (email.get().isNullOrEmpty() || password.get().isNullOrEmpty()) {
            message.postValue("Not all fields filled!")
        } else {
            progressBarVisibility.set(View.VISIBLE)
            auth.signInWithEmailAndPassword(email.get(), password.get())
                    .addOnCompleteListener {
                        Log.d(TAG, "Auth complete:")
                        progressBarVisibility.set(View.GONE)
                    }
                    .addOnSuccessListener {
                        Log.d(TAG, "Auth success:")
                        navigation.postValue(NavigationEvent(MainActivity::class.java))
                    }
                    .addOnFailureListener { exception ->
                        Log.d(TAG, "Auth failure: ${exception.localizedMessage}")
                        message.postValue("Failure: ${exception.localizedMessage}")
                    }
        }
    }

    fun onSignUpAction() {
        navigation.postValue(NavigationEvent(SignUpActivity::class.java))
    }
}
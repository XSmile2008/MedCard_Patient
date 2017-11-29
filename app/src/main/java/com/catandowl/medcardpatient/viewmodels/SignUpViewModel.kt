package com.catandowl.medcardpatient.viewmodels

import android.databinding.ObservableField
import android.databinding.ObservableInt
import android.util.Log
import android.view.View
import com.catandowl.medcardpatient.activities.MainActivity
import com.catandowl.medcardpatient.events.NavigationEvent
import com.google.firebase.auth.FirebaseAuth

/**
 * Created by vladstarikov on 11/27/17.
 */
class SignUpViewModel(val auth: FirebaseAuth) : BaseViewModel() {

    companion object {
        private val TAG = SignUpViewModel::class.java.simpleName
    }

    val email = ObservableField<String>("tako@burito.com")
    val password = ObservableField<String>()
    val passwordConfirm = ObservableField<String>()
    val progressBarVisibility = ObservableInt(View.GONE)

    fun onSignUpAction() {
        Log.d(javaClass.name, "onSignInAction: email = ${email.get()}, password = ${password.get()})")
        if (email.get().isNullOrEmpty() || password.get().isNullOrEmpty() || passwordConfirm.get().isNullOrEmpty()) {
            message.postValue("Not all fields filled!")
        } else if (password.get() != passwordConfirm.get()) {
            message.postValue("Passwords is not equal")
        } else {
            progressBarVisibility.set(View.VISIBLE)
            auth.createUserWithEmailAndPassword(email.get(), password.get())
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
}
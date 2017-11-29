package com.catandowl.medcardpatient.viewmodels

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.databinding.ObservableField
import android.databinding.ObservableInt
import android.text.TextUtils
import android.util.Log
import android.view.View
import com.catandowl.medcardpatient.activities.MainActivity
import com.catandowl.medcardpatient.events.NavigationEvent
import com.google.firebase.auth.FirebaseAuth

/**
 * Created by vladstarikov on 11/27/17.
 */
class SignInViewModel(val auth: FirebaseAuth) : ViewModel() {

    companion object {
        private val TAG = SignInViewModel::class.java.simpleName
    }

    val nav = MutableLiveData<NavigationEvent>()
    val message = MutableLiveData<String>()

    val email = ObservableField<String>("tako@burito.com")
    val password = ObservableField<String>()
    val progressBarVisibility = ObservableInt(View.GONE)

    fun onSignInAction() {
        Log.d(javaClass.name, "onSignInAction: email = ${email.get()}, password = ${password.get()})")
        if (TextUtils.isEmpty(email.get()) || TextUtils.isEmpty(password.get())) {

        } else {
            progressBarVisibility.set(View.VISIBLE)
            auth.signInWithEmailAndPassword(email.get(), password.get())
                    .addOnCompleteListener {
                        Log.d(TAG, "Auth complete:")
                        progressBarVisibility.set(View.GONE)
                    }
                    .addOnSuccessListener {
                        Log.d(TAG, "Auth success:")
                        nav.postValue(NavigationEvent(MainActivity::class.java))
                    }
                    .addOnFailureListener { exception ->
                        Log.d(TAG, "Auth failure: ${exception.localizedMessage}")
                        message.postValue("Failure")
                    }
        }
    }
}
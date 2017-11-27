package com.catandowl.medcardpatient.dagger

import com.google.firebase.auth.FirebaseAuth
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by vladstarikov on 11/27/17.
 */
class FirebaseModule {

    @Provides
    @Singleton
    fun provideFirebaseAuth(): FirebaseAuth = FirebaseAuth.getInstance()
}
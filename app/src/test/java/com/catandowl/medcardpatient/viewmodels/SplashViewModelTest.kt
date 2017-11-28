package com.catandowl.medcardpatient.viewmodels

import android.app.Application
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

/**
 * Created by vladstarikov on 11/28/17.
 */
@RunWith(MockitoJUnitRunner::class)
class SplashViewModelTest {

    @Mock
    private lateinit var application: Application

    @Mock
    private lateinit var auth: FirebaseAuth

    @Mock
    private lateinit var user: FirebaseUser

    @Test
    fun checkCreate() {
        `when`(auth.currentUser).thenReturn(null)
        SplashViewModel(application, auth)
        verify(auth).currentUser
//        verify(application).startActivity(eq(Intent(application, SignInActivity::class.java)))
    }
}
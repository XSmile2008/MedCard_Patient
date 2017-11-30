package com.catandowl.medcardpatient.viewmodels

import com.google.firebase.auth.FirebaseAuth
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
    private lateinit var auth: FirebaseAuth

    @Test
    fun checkCreate() {
        `when`(auth.currentUser).thenReturn(null)
        SplashViewModel(auth)
        verify(auth).currentUser
    }

    @Test
    fun check() {
//        assertTrue(TextUtils.equals("a", "a"))
//        assertFalse(TextUtils.equals("a", "b"))
    }
}
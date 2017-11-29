package com.catandowl.medcardpatient.viewmodels

import com.google.firebase.auth.FirebaseAuth
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

/**
 * Created by vladstarikov on 11/29/17.
 */
@RunWith(MockitoJUnitRunner::class)
class SignInViewModelTest {

    @Mock
    private lateinit var auth: FirebaseAuth

    @Test
    fun checkCreate() {
        val viewModel = SignInViewModel(auth)
        viewModel.email.set("tako@burito.com")
        viewModel.password.set("qwerty")
        viewModel.onSignInAction()

//        verify(application).startActivity(eq(Intent(application, SignInActivity::class.java)))
    }
}
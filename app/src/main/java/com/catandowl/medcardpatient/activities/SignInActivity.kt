package com.catandowl.medcardpatient.activities

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import com.catandowl.medcardpatient.R
import com.catandowl.medcardpatient.databinding.ActivitySignInBinding
import com.catandowl.medcardpatient.viewmodels.SignInViewModel

/**
 * Created by vladstarikov on 11/27/17.
 */
class SignInActivity : BaseActivity() {

    private lateinit var viewModel: SignInViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(SignInViewModel::class.java)
        val binding: ActivitySignInBinding = DataBindingUtil.setContentView(this, R.layout.activity_sign_in)
        binding.viewModel = viewModel
    }
}
package com.catandowl.medcardpatient.activities

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.widget.Toast
import com.catandowl.medcardpatient.R
import com.catandowl.medcardpatient.databinding.ActivitySignUpBinding
import com.catandowl.medcardpatient.viewmodels.SignUpViewModel

/**
 * Created by vladstarikov on 11/27/17.
 */
class SignUpActivity : BaseActivity() {

    private lateinit var viewModel: SignUpViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(SignUpViewModel::class.java)
        val binding: ActivitySignUpBinding = DataBindingUtil.setContentView(this, R.layout.activity_sign_up)
        binding.viewModel = viewModel

        viewModel.getNavigation().observe(this, Observer {
            when (it?.clazz) {
                MainActivity::class.java -> {
                    startActivity(Intent(this, it.clazz).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK))
                    finish()
                }
            }
        })

        viewModel.getMessage().observe(this, Observer { Toast.makeText(this, it, Toast.LENGTH_SHORT).show() })
    }

    override fun onContentChanged() {
        super.onContentChanged()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
}
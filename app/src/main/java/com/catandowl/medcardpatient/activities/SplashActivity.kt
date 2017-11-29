package com.catandowl.medcardpatient.activities

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.Bundle
import com.catandowl.medcardpatient.viewmodels.SplashViewModel

/**
 * Created by vladstarikov on 11/27/17.
 */
class SplashActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel = ViewModelProviders.of(this, viewModelFactory).get(SplashViewModel::class.java)
        viewModel.getNavigation().observe(this, Observer {
            it?.clazz?.let {
                startActivity(Intent(this, it))
                finish()
            }
        })
    }
}
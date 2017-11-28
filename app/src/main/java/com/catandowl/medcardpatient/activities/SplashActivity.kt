package com.catandowl.medcardpatient.activities

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import com.catandowl.medcardpatient.viewmodels.SplashViewModel

/**
 * Created by vladstarikov on 11/27/17.
 */
class SplashActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ViewModelProviders.of(this, viewModelFactory).get(SplashViewModel::class.java)
    }
}
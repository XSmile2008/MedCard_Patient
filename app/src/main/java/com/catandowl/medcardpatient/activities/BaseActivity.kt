package com.catandowl.medcardpatient.activities

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.catandowl.medcardpatient.AppClass
import com.catandowl.medcardpatient.viewmodels.factory.ViewModelFactory
import javax.inject.Inject

/**
 * Created by vladstarikov on 11/28/17.
 */
abstract class BaseActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppClass.component.inject(this)
    }
}
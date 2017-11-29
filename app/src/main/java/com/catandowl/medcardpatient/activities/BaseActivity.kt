package com.catandowl.medcardpatient.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
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

    override fun onOptionsItemSelected(item: MenuItem?): Boolean = when (item?.itemId) {
        android.R.id.home -> {
            onBackPressed()
            true
        }
        else -> super.onOptionsItemSelected(item)
    }
}
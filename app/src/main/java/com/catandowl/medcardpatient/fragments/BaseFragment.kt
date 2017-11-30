package com.catandowl.medcardpatient.fragments

import android.content.Context
import android.support.v4.app.Fragment
import com.catandowl.medcardpatient.AppClass
import com.catandowl.medcardpatient.viewmodels.factory.ViewModelFactory
import javax.inject.Inject

/**
 * Created by vladstarikov on 11/30/17.
 */
open class BaseFragment: Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        AppClass.component.inject(this)
    }
}
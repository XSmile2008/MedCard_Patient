package com.catandowl.medcardpatient.viewmodels

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import com.catandowl.medcardpatient.events.NavigationEvent
import com.catandowl.medcardpatient.events.SingleLiveEvent

/**
 * Created by vladstarikov on 11/29/17.
 */
abstract class BaseViewModel : ViewModel() {

    protected val navigation = SingleLiveEvent<NavigationEvent>()
    fun getNavigation(): LiveData<NavigationEvent> = navigation

    protected val message = SingleLiveEvent<String>()
    fun getMessage(): LiveData<String> = message
}
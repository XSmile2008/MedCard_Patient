package com.catandowl.medcardpatient

import android.app.Application
import com.catandowl.medcardpatient.dagger.AppComponent
import com.catandowl.medcardpatient.dagger.AppModule
import com.catandowl.medcardpatient.dagger.DaggerAppComponent

/**
 * Created by vladstarikov on 11/27/17.
 */
class AppClass : Application() {

    init {
        component = DaggerAppComponent.builder().appModule(AppModule(this)).build()
        component.inject(this)
    }

    override fun onCreate() {
        super.onCreate()
    }

    companion object {
        lateinit var component: AppComponent
    }
}
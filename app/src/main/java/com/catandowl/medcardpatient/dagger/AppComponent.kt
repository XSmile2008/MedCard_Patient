package com.catandowl.medcardpatient.dagger

import com.catandowl.medcardpatient.AppClass
import com.catandowl.medcardpatient.activities.MainActivity
import dagger.Component
import javax.inject.Singleton

/**
 * Created by vladstarikov on 10/21/17.
 */

@Singleton
@Component(modules = arrayOf(AppModule::class, FirebaseModule::class))
interface AppComponent {
    //Application

    fun inject(appClass: AppClass)


    //Activities

    fun inject(activity: MainActivity)


    //Fragments


    //Other

}

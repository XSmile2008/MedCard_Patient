package com.catandowl.medcardpatient.dagger

import com.catandowl.medcardpatient.AppClass
import com.catandowl.medcardpatient.activities.BaseActivity
import com.catandowl.medcardpatient.activities.MainActivity
import com.catandowl.medcardpatient.fragments.BaseFragment
import com.catandowl.medcardpatient.viewmodels.SplashViewModel
import com.catandowl.medcardpatient.viewmodels.factory.ViewModelFactory
import dagger.Component
import javax.inject.Singleton

/**
 * Created by vladstarikov on 10/21/17.
 */

@Singleton
@Component(modules = [AppModule::class, FirebaseModule::class])
interface AppComponent {
    //Application

    fun inject(appClass: AppClass)


    //Activities

    fun inject(baseActivity: BaseActivity)
    fun inject(mainActivity: MainActivity)

    //Fragments
    fun inject(baseFragment: BaseFragment)


    //ViewModels
    fun inject(viewModelFactory: ViewModelFactory)

    fun inject(splashViewModel: SplashViewModel)


    //Other

}
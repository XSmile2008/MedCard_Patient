package com.catandowl.medcardpatient.dagger.modules

import android.app.Application
import android.content.Context
import com.catandowl.medcardpatient.utils.ToastUtils
import com.catandowl.medcardpatient.viewmodels.factory.ViewModelFactory
import dagger.Module
import dagger.Provides
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.Router
import javax.inject.Singleton

/**
 * Created by vladstarikov on 10/21/17.
 */

@Module
class AppModule(private val app: Application) {

    @Provides
    @Singleton
    fun provideApplication(): Application = app

    @Provides
    @Singleton
    fun provideContext(): Context = app

    @Provides
    @Singleton
    fun provideCicerone(): Cicerone<Router> = Cicerone.create()

    @Provides
    @Singleton
    fun provideNavigationHolder(cicerone: Cicerone<Router>): NavigatorHolder = cicerone.navigatorHolder

    @Provides
    @Singleton
    fun provideRouter(cicerone: Cicerone<Router>): Router = cicerone.router
}
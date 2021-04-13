package com.drus.githubsearch.mvvm

import com.drus.githubsearch.mvvm.dagger.AppComponent
import com.drus.githubsearch.mvvm.dagger.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class App : DaggerApplication() {
    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        initDagger()
        super.onCreate()
        appComponent.inject(this)
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> = appComponent

    private fun initDagger() {
        appComponent = DaggerAppComponent.builder()
            .application(this)
            .build()
    }
}
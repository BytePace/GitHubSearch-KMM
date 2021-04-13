package com.drus.githubsearch.mvvm.dagger

import com.drus.githubsearch.core.utils.ActivityScope
import com.drus.githubsearch.mvvm.presentation.activity.MainActivity
import com.drus.githubsearch.mvvm.presentation.activity.MainActivityModule
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.android.support.AndroidSupportInjectionModule

@Module(includes = [AndroidSupportInjectionModule::class])
interface ActivitiesModule {
    @ActivityScope
    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    fun contributeToMainActivity(): MainActivity
}
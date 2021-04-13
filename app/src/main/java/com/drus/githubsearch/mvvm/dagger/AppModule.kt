package com.drus.githubsearch.mvvm.dagger

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import com.drus.githubsearch.core.utils.ActivityScope
import com.drus.githubsearch.core.utils.ApplicationContext
import com.drus.githubsearch.core.utils.ViewModelFactory
import com.drus.githubsearch.mvvm.App
import dagger.Binds
import dagger.Module

@Module
interface AppModule {
    @Binds
    @ApplicationContext
    fun bindApplicationContext(application: App): Context

    @Binds
    fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}
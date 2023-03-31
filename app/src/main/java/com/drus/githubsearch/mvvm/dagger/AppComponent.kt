package com.drus.githubsearch.mvvm.dagger

import com.drus.githubsearch.core.utils.AppScope
import com.drus.githubsearch.mvvm.App
import com.drus.githubsearch.navigation.NavigationModule
import com.drus.githubsearch.networking.NetworkModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector

@AppScope
@Component(modules = [
    AppModule::class,
    ActivitiesModule::class,
    NetworkModule::class,
    NavigationModule::class
])
interface AppComponent : AndroidInjector<App> {
    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: App): Builder

        fun build(): AppComponent
    }
}
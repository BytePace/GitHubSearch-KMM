package com.drus.githubsearch.navigation

import com.drus.githubsearch.core.utils.AppScope
import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import dagger.Module
import dagger.Provides

@Module
interface NavigationModule {
    companion object {
        @Provides
        @AppScope
        fun provideCicerone(): Cicerone<Router> = Cicerone.create()

        @Provides
        @AppScope
        fun provideRouter(cicerone: Cicerone<Router>): Router = cicerone.router

        @Provides
        @AppScope
        fun provideNavigationHolder(cicerone: Cicerone<Router>): NavigatorHolder {
            return cicerone.getNavigatorHolder()
        }
    }
}
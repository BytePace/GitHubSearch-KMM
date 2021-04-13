package com.drus.githubsearch.mvvm.presentation.activity

import android.content.Context
import android.view.inputmethod.InputMethodManager
import androidx.lifecycle.ViewModel
import com.drus.githubsearch.core.utils.ActivityScope
import com.drus.githubsearch.core.utils.FragmentScope
import com.drus.githubsearch.core.utils.ViewModelKey
import com.drus.githubsearch.core.utils.getSystemService
import com.drus.githubsearch.mvvm.presentation.screens.repositoryDetails.RepositoryDetailsFragment
import com.drus.githubsearch.mvvm.presentation.screens.repositoryDetails.RepositoryDetailsModule
import com.drus.githubsearch.mvvm.presentation.screens.search.SearchFragment
import com.drus.githubsearch.mvvm.presentation.screens.search.SearchFragmentModule
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.Router

@Module
interface MainActivityModule {
    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    fun bindMedProfileViewModel(viewModel: MainViewModel): ViewModel

    @FragmentScope
    @ContributesAndroidInjector(modules = [SearchFragmentModule::class])
    fun contributeToSearchFragment(): SearchFragment

    @FragmentScope
    @ContributesAndroidInjector(modules = [RepositoryDetailsModule::class])
    fun contributeToRepositoryDetailsFragment(): RepositoryDetailsFragment

    companion object {
        @Provides
        @ActivityScope
        fun provideInputManager(activity: MainActivity): InputMethodManager {
            return activity.getSystemService<InputMethodManager>(Context.INPUT_METHOD_SERVICE)
        }

        @Provides
        @ActivityScope
        fun provideCicerone() = Cicerone.create(Router())

        @Provides
        @ActivityScope
        fun provideRouter(cicerone: Cicerone<Router>) = cicerone.router

        @Provides
        @ActivityScope
        fun provideNavigatorHolder(cicerone: Cicerone<Router>) = cicerone.navigatorHolder
    }
}
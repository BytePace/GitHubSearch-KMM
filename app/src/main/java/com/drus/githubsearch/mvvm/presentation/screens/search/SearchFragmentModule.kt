package com.drus.githubsearch.mvvm.presentation.screens.search

import androidx.lifecycle.ViewModel
import com.drus.githubsearch.core.utils.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface SearchFragmentModule {
    @Binds
    @IntoMap
    @ViewModelKey(SearchViewModel::class)
    fun bindMedProfileViewModel(viewModel: SearchViewModel): ViewModel
}
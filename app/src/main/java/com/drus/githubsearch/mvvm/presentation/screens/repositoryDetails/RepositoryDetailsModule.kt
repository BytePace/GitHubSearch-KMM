package com.drus.githubsearch.mvvm.presentation.screens.repositoryDetails

import androidx.lifecycle.ViewModel
import com.drus.githubsearch.core.utils.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface RepositoryDetailsModule {
    @Binds
    @IntoMap
    @ViewModelKey(RepositoryDetailsViewModel::class)
    fun bindMedProfileViewModel(viewModel: RepositoryDetailsViewModel): ViewModel
}
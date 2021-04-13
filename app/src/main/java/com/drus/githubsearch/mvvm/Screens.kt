package com.drus.githubsearch.mvvm

import androidx.core.os.bundleOf
import com.drus.githubsearch.core.navigation.BaseScreen
import com.drus.githubsearch.mvvm.presentation.screens.repositoryDetails.RepositoryDetailsFragment
import com.drus.githubsearch.mvvm.presentation.screens.search.SearchFragment
import com.drus.githubsearch.networking.models.SimpleRepositoryInfo

object Screens {
    fun search() = BaseScreen(SearchFragment())
    fun repositoryDetails(info: SimpleRepositoryInfo) = BaseScreen(RepositoryDetailsFragment(), bundleOf(
        RepositoryDetailsFragment.INFO to info
    ))
}
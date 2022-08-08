package com.drus.githubsearch.search

import androidx.core.os.bundleOf
import com.drus.githubsearch.core.navigation.BaseScreen
import com.drus.githubsearch.networking.models.SimpleRepositoryInfo
import com.drus.githubsearch.search.screens.repositoryDetails.RepositoryDetailsFragment
import com.drus.githubsearch.search.screens.search.SearchFragment

object Screens {
    fun search() = BaseScreen(SearchFragment())
    fun repositoryDetails(info: SimpleRepositoryInfo) = BaseScreen(
        RepositoryDetailsFragment(), bundleOf(
            RepositoryDetailsFragment.INFO to info
        )
    )
}
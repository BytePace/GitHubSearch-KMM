package com.drus.githubsearch.search

import com.drus.githubsearch.networking.models.SimpleRepositoryInfo
import com.drus.githubsearch.search.screens.repositoryDetails.RepositoryDetailsFragment
import com.drus.githubsearch.search.screens.search.SearchFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

object Screens {
    fun search() = FragmentScreen { SearchFragment() }
    fun repositoryDetails(info: SimpleRepositoryInfo) = FragmentScreen {
        RepositoryDetailsFragment.newInstance(info)
    }
}
package com.drus.githubsearch.networking.repository

import com.drus.githubsearch.networking.models.RepositoryDetails
import com.drus.githubsearch.networking.models.SimpleRepositoryInfo

interface GitHubRepository {
    suspend fun search(keyword: String?, from: Int, count: Int): List<SimpleRepositoryInfo>
    suspend fun getDetails(info: SimpleRepositoryInfo?): RepositoryDetails?
}
package com.drus.githubsearch.networking

import com.drus.githubsearch.networking.models.RepositoryDetails
import com.drus.githubsearch.networking.models.RepositoryInfoList
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface NetworkService {
    @GET("search/repositories")
    fun searchRepositories(
        @Query("q") keyWord: String,
        @Query("page") pageNum: Int,
        @Query("per_page") sizePage: Int
    ): Deferred<Response<RepositoryInfoList>>

    @GET("repos/{owner}/{repo}/branches/master")
    fun getRepositoryDetails(
        @Path("owner") owner: String,
        @Path("repo") repo: String
    ): Deferred<Response<RepositoryDetails>>
}
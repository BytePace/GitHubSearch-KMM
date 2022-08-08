package com.drus.githubsearch.search.screens.search.adapter

import androidx.paging.DataSource
import androidx.paging.PositionalDataSource
import com.drus.githubsearch.networking.models.SimpleRepositoryInfo
import com.drus.githubsearch.networking.repository.GitHubRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class RepositoriesDataSourceFactory(
    private val searchText: String,
    private val networkRepository: GitHubRepository,
    private val scope: CoroutineScope
) : DataSource.Factory<Int, SimpleRepositoryInfo>() {
    override fun create(): DataSource<Int, SimpleRepositoryInfo> {
        return object : PositionalDataSource<SimpleRepositoryInfo>() {
            override fun loadInitial(
                params: LoadInitialParams,
                callback: LoadInitialCallback<SimpleRepositoryInfo>
            ) {
                scope.launch(Dispatchers.IO) {
                    val result = networkRepository.search(
                        searchText,
                        params.requestedStartPosition,
                        params.pageSize
                    )
                    withContext(Dispatchers.Main) {
                        callback.onResult(
                            result,
                            params.requestedStartPosition
                        )
                    }
                }
            }

            override fun loadRange(
                params: LoadRangeParams,
                callback: LoadRangeCallback<SimpleRepositoryInfo>
            ) {
                scope.launch {
                    val result = networkRepository.search(
                        searchText,
                        params.startPosition,
                        params.loadSize
                    )
                    withContext(Dispatchers.Main) {
                        callback.onResult(result)
                    }
                }
            }
        }
    }
}
package com.drus.githubsearch.mvvm.presentation.screens.search

import androidx.lifecycle.*
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.drus.githubsearch.core.presentation.BaseViewModel
import com.drus.githubsearch.mvvm.Screens
import com.drus.githubsearch.mvvm.presentation.screens.search.adapter.RepositoriesAdapter
import com.drus.githubsearch.mvvm.presentation.screens.search.adapter.RepositoriesDataSourceFactory
import com.drus.githubsearch.networking.models.SimpleRepositoryInfo
import com.drus.githubsearch.networking.repository.GitHubRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.debounce
import ru.terrakok.cicerone.Router
import javax.inject.Inject

class SearchViewModel @Inject constructor(
    private val networkRepository: GitHubRepository,
    private val router: Router
) : BaseViewModel() {

    val repositoriesAdapter = RepositoriesAdapter {
        router.navigateTo(Screens.repositoryDetails(it))
    }

    val searchText = MutableLiveData<String>("")

    val emptySource = MutableLiveData<Boolean>(true).apply {
        distinctUntilChanged()
    }

    @FlowPreview
    private val searchState: LiveData<String>
        get() = searchText.asFlow().debounce(500).asLiveData(Dispatchers.Default)

    @FlowPreview
    private val dataSource = Transformations.switchMap(searchState) {
        LivePagedListBuilder(
            RepositoriesDataSourceFactory(it, networkRepository, viewModelScope),
            pagingConfig
        ).setBoundaryCallback(boundaryCallback)
            .build()
    }

    private val pagingConfig = PagedList.Config.Builder()
        .setEnablePlaceholders(false)
        .setPageSize(15)
        .build()

    private val boundaryCallback = object : PagedList.BoundaryCallback<SimpleRepositoryInfo>() {
        override fun onZeroItemsLoaded() {
            emptySource.value = true
        }
    }

    @FlowPreview
    fun startInit(lifecycleOwner: LifecycleOwner) {
        dataSource.observe(lifecycleOwner, Observer {
            if (it.isNotEmpty()) emptySource.value = false
            repositoriesAdapter.submitList(it)
        })
    }
}
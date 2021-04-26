package com.drus.githubsearch.mvvm.presentation.screens.search

import android.text.Editable
import androidx.lifecycle.*
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.drus.githubsearch.core.presentation.BaseViewModel
import com.drus.githubsearch.mvvm.R
import com.drus.githubsearch.mvvm.Screens
import com.drus.githubsearch.mvvm.data.screens.search.TextValidationStatus
import com.drus.githubsearch.mvvm.presentation.screens.search.adapter.RepositoriesAdapter
import com.drus.githubsearch.mvvm.presentation.screens.search.adapter.RepositoriesDataSourceFactory
import com.drus.githubsearch.mvvm.presentation.screens.search.validation.SearchValidationUtil
import com.drus.githubsearch.networking.models.SimpleRepositoryInfo
import com.drus.githubsearch.networking.repository.GitHubRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.debounce
import ru.terrakok.cicerone.Router
import javax.inject.Inject

class SearchViewModel @Inject constructor(
    private val networkRepository: GitHubRepository,
    private val validationUtil: SearchValidationUtil,
    private val router: Router
) : BaseViewModel() {

    val repositoriesAdapter = RepositoriesAdapter {
        router.navigateTo(Screens.repositoryDetails(it))
    }

    val isSourceEmpty = MutableLiveData<Boolean>(true)

    val errorStateText: LiveData<Int?>
        get() = validationUtil.validationStatusLiveData.map {
            if (it.searchText.status != TextValidationStatus.CORRECT && it.searchText.showErrorState) {
                R.string.search_text_too_small_error
            } else {
                null
            }
        }

    private val searchText = MutableLiveData<String>("")

    @FlowPreview
    private val searchState: LiveData<String>
        get() = searchText.asFlow().debounce(SEARCH_DEBOUNCE).asLiveData(Dispatchers.Default)

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
            isSourceEmpty.value = true
        }
    }

    fun onSearchTextChanged(text: Editable?) {
        val result = text.toString()
        validationUtil.validateSearchText(result, true)
        searchText.value = if (validationUtil.validationStatusLiveData.value?.isAllValid == true) {
            result
        } else {
            ""
        }
    }

    @FlowPreview
    fun startInit(lifecycleOwner: LifecycleOwner) {
        dataSource.observe(lifecycleOwner, Observer {
            if (it.isNotEmpty()) isSourceEmpty.value = false
            repositoriesAdapter.submitList(it)
        })
    }

    private companion object {
        const val SEARCH_DEBOUNCE = 500L
    }
}
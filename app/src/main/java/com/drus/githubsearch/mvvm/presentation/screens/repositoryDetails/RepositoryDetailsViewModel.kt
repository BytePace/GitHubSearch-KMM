package com.drus.githubsearch.mvvm.presentation.screens.repositoryDetails

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.drus.githubsearch.core.presentation.BaseViewModel
import com.drus.githubsearch.networking.models.SimpleRepositoryInfo
import com.drus.githubsearch.networking.repository.GitHubRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import ru.terrakok.cicerone.Router
import javax.inject.Inject

class RepositoryDetailsViewModel @Inject constructor(
    private val networkRepository: GitHubRepository,
    private val router: Router
) : BaseViewModel() {

    val info = MutableLiveData<SimpleRepositoryInfo>()
    val date = MutableLiveData<String>()

    fun startInit(info: SimpleRepositoryInfo) {
        this.info.value = info
        viewModelScope.launch(Dispatchers.IO) {
            val details = networkRepository.getDetails(info)
            withContext(Dispatchers.Main) {
                date.value = details?.commit?.details?.author?.date
            }
        }
    }

    fun back() {
        router.exit()
    }
}
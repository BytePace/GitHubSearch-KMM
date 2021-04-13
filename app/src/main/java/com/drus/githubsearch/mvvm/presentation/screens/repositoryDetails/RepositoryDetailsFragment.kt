package com.drus.githubsearch.mvvm.presentation.screens.repositoryDetails

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.drus.githubsearch.core.utils.ViewModelFactory
import com.drus.githubsearch.mvvm.R
import com.drus.githubsearch.mvvm.databinding.FragmentRepositoryDetailsBinding
import com.drus.githubsearch.mvvm.presentation.screens.BaseFragment
import com.drus.githubsearch.networking.models.SimpleRepositoryInfo
import javax.inject.Inject

class RepositoryDetailsFragment:
    BaseFragment<RepositoryDetailsViewModel, FragmentRepositoryDetailsBinding>(R.layout.fragment_repository_details) {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    override val viewModel by viewModels<RepositoryDetailsViewModel> { viewModelFactory }

    companion object {
        private const val TAG = "RepositoryDetailsFragment"
        const val INFO = "$TAG:info"
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requireArguments().getParcelable<SimpleRepositoryInfo>(INFO)?.let {
            viewModel.startInit(it)
        }
    }
}
package com.drus.githubsearch.search.screens.search

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.drus.githubsearch.core.utils.ViewModelFactory
import com.drus.githubsearch.search.R
import com.drus.githubsearch.search.databinding.FragmentSearchRepositoriesBinding
import com.drus.githubsearch.search.screens.BaseFragment
import kotlinx.coroutines.FlowPreview
import javax.inject.Inject

class SearchFragment :
    BaseFragment<SearchViewModel, FragmentSearchRepositoriesBinding>(R.layout.fragment_search_repositories) {
    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    override val viewModel by viewModels<SearchViewModel> { viewModelFactory }

    @FlowPreview
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.startInit(viewLifecycleOwner)
        binding.recyclerView.layoutManager?.onRestoreInstanceState(
            savedInstanceState?.getParcelable(RV_STATE)
        )
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putParcelable(RV_STATE, binding.recyclerView.layoutManager?.onSaveInstanceState())
    }

    private companion object {
        private const val TAG = "SearchFragment"
        const val RV_STATE = "$TAG:rvState"
    }
}
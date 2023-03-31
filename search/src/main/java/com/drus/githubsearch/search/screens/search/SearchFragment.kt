package com.drus.githubsearch.search.screens.search

import android.os.Bundle
import android.view.View
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.drus.githubsearch.core.utils.ViewModelFactory
import com.drus.githubsearch.search.R
import com.drus.githubsearch.search.adapters.setErrorText
import com.drus.githubsearch.search.databinding.FragmentSearchRepositoriesBinding
import dagger.android.support.DaggerFragment
import kotlinx.coroutines.FlowPreview
import javax.inject.Inject

class SearchFragment : DaggerFragment(R.layout.fragment_search_repositories) {
    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private val viewModel by viewModels<SearchViewModel> { viewModelFactory }
    private val binding by viewBinding(FragmentSearchRepositoriesBinding::bind)


    @FlowPreview
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.startInit(viewLifecycleOwner)
        binding.searchInputLayout.apply {
            editText.addTextChangedListener {
                viewModel.onSearchTextChanged(it)
            }
            setErrorText(viewModel.errorStateText.value)
        }
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            layoutManager?.onRestoreInstanceState(
                savedInstanceState?.getParcelable(RV_STATE)
            )
            adapter = viewModel.repositoriesAdapter
        }
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
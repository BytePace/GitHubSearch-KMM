package com.drus.githubsearch.search.screens.repositoryDetails

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.drus.githubsearch.core.utils.ViewModelFactory
import com.drus.githubsearch.networking.models.SimpleRepositoryInfo
import com.drus.githubsearch.search.R
import com.drus.githubsearch.search.adapters.setSafeClickListener
import com.drus.githubsearch.search.databinding.FragmentRepositoryDetailsBinding
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class RepositoryDetailsFragment : DaggerFragment(R.layout.fragment_repository_details) {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private val viewModel by viewModels<RepositoryDetailsViewModel> { viewModelFactory }
    private val binding by viewBinding(FragmentRepositoryDetailsBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requireArguments().getParcelable<SimpleRepositoryInfo>(INFO)?.let {
            viewModel.startInit(it)
        }
        binding.title.apply {
            setSafeClickListener {
                viewModel.back()
            }
        }
        binding.date.apply {
            setSafeClickListener {
                viewModel.back()
            }
            viewModel.date.observe(viewLifecycleOwner) {
                text = it
                isVisible = it != null && it.isNotEmpty()
            }

        }
    }

    companion object {
        private const val TAG = "RepositoryDetailsFragment"
        const val INFO = "$TAG:info"

        fun newInstance(
            info: SimpleRepositoryInfo
        ) = RepositoryDetailsFragment().apply {
            arguments = bundleOf(
                INFO to info
            )
        }
    }
}
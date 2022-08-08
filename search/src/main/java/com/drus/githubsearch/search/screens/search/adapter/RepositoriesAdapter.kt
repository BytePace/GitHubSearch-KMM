package com.drus.githubsearch.search.screens.search.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.paging.PagedListAdapter
import com.drus.githubsearch.networking.models.SimpleRepositoryInfo
import com.drus.githubsearch.search.BR
import com.drus.githubsearch.search.R
import com.drus.githubsearch.search.adapters.BaseRVHolder
import com.drus.githubsearch.search.adapters.SimpleDiffUtilCallback

class RepositoriesAdapter(
    private val onItemSelected: (SimpleRepositoryInfo) -> Unit
) : PagedListAdapter<SimpleRepositoryInfo, RepositoriesAdapter.ViewHolder>(
    SimpleDiffUtilCallback<SimpleRepositoryInfo>()
) {
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position), BR.item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_holder_repository,
                parent, false
            )
        )
    }

    inner class ViewHolder(binding: ViewDataBinding) : BaseRVHolder<SimpleRepositoryInfo>(
        binding, onItemSelected
    )
}
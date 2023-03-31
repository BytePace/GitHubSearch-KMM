package com.drus.githubsearch.search.screens.search.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.drus.githubsearch.networking.models.SimpleRepositoryInfo
import com.drus.githubsearch.search.adapters.SimpleDiffUtilCallback
import com.drus.githubsearch.search.databinding.ItemHolderRepositoryBinding

class RepositoriesAdapter(
    private val onItemSelected: (SimpleRepositoryInfo) -> Unit
) : PagedListAdapter<SimpleRepositoryInfo, RepositoriesAdapter.ViewHolder>(
    SimpleDiffUtilCallback<SimpleRepositoryInfo>()
) {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemHolderRepositoryBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    inner class ViewHolder(private val binding: ItemHolderRepositoryBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: SimpleRepositoryInfo?) {
            item?.let { info ->
                binding.root.setOnClickListener { onItemSelected(info) }
                binding.textRepository.text = info.repositoryName
                binding.textOwner.text = info.repositoryOwner.userName
                binding.textDate.text = info.date
            }
        }
    }
}
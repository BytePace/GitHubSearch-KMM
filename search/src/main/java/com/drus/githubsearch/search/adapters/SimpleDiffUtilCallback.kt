package com.drus.githubsearch.search.adapters

import android.annotation.SuppressLint
import androidx.recyclerview.widget.DiffUtil

class SimpleDiffUtilCallback<T>: DiffUtil.ItemCallback<T>() {
    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(oldItem: T, newItem: T): Boolean {
        return oldItem == newItem
    }

    override fun areItemsTheSame(oldItem: T, newItem: T): Boolean {
        return oldItem == newItem
    }
}
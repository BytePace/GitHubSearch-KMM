package com.drus.githubsearch.mvvm.presentation.adapters

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.drus.githubsearch.core.utils.SafeClickListener

abstract class BaseRVHolder<T>(
    protected val viewBinding: ViewDataBinding,
    onClickListener: ((T) -> Unit)? = null
) : RecyclerView.ViewHolder(viewBinding.root) {
    private var item: T? = null

    init {
        onClickListener?.let { clickListener ->
            viewBinding.root.setOnClickListener(SafeClickListener {
                item?.let { clickListener.invoke(it) }
            })
        }
    }

    open fun bind(item: T?, variableId: Int) {
        this.item = item
        viewBinding.setVariable(variableId, item)
    }
}
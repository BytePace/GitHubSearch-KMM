package com.drus.githubsearch.core.presentation

import android.app.Application
import android.content.Context
import android.graphics.drawable.Drawable
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.core.content.ContextCompat
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

abstract class BaseViewModelWithContext(
    app: Application
) : AndroidViewModel(app) {

    protected val context: Context
        get() = getApplication()

    fun launch(
        context: CoroutineContext = Dispatchers.Default,
        block: suspend CoroutineScope.() -> Unit
    ): Job {
        return viewModelScope.launch(context, block = block)
    }

    fun launch(
        exceptionHandler: CoroutineExceptionHandler,
        block: suspend CoroutineScope.() -> Unit
    ): Job {
        return viewModelScope.launch(exceptionHandler, block = block)
    }

    protected fun getColor(@ColorRes id: Int): Int {
        return ContextCompat.getColor(context, id)
    }

    protected fun getDrawable(@DrawableRes id: Int): Drawable? {
        return ContextCompat.getDrawable(context, id)
    }

    protected fun getString(@StringRes id: Int): String {
        return context.getString(id)
    }
}
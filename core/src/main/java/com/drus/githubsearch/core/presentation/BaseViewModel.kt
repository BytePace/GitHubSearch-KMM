package com.drus.githubsearch.core.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

abstract class BaseViewModel : ViewModel() {
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
}
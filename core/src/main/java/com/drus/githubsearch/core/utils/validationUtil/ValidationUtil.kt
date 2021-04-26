package com.drus.githubsearch.core.utils.validationUtil

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

abstract class ValidationUtil<T : Any, S : ValidationStatus> {
    private val innerValidationStatusLiveData = MutableLiveData<S>()

    protected var validationStatus: S
        get() = innerValidationStatusLiveData.value ?: defaultValidationStatus
        set(value) {
            innerValidationStatusLiveData.value = value
        }

    val validationStatusLiveData: LiveData<S>
        get() = innerValidationStatusLiveData

    protected abstract val defaultValidationStatus: S

    fun validateAll(item: T?, showError: Boolean) {
        validationStatus = if (item == null) {
            defaultValidationStatus
        } else {
            getValidationStatus(item, showError)
        }
    }

    protected abstract fun getValidationStatus(item: T, showError: Boolean): S
}
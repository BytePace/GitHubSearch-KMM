package com.drus.githubsearch.core.utils.validationUtil

data class PropertyValidationStatus<T>(
    val status: T,
    val showErrorState: Boolean
)
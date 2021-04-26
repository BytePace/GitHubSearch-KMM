package com.drus.githubsearch.mvvm.presentation.screens.search.validation

import com.drus.githubsearch.core.utils.validationUtil.PropertyValidationStatus
import com.drus.githubsearch.core.utils.validationUtil.ValidationStatus
import com.drus.githubsearch.mvvm.data.screens.search.TextValidationStatus

data class SearchValidationStatus(
    val searchText: PropertyValidationStatus<TextValidationStatus>
): ValidationStatus {

    constructor(): this(
        PropertyValidationStatus(TextValidationStatus.TOO_SHORT, false)
    )

    override val isAllValid: Boolean
        get() = searchText.status == TextValidationStatus.CORRECT
}
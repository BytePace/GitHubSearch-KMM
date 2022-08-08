package com.drus.githubsearch.search.screens.search.validation

import com.drus.githubsearch.core.utils.validationUtil.PropertyValidationStatus
import com.drus.githubsearch.core.utils.validationUtil.ValidationStatus
import com.drus.githubsearch.search.utils.TextValidationStatus

data class SearchValidationStatus(
    val searchText: PropertyValidationStatus<TextValidationStatus>
): ValidationStatus {

    constructor(): this(
        PropertyValidationStatus(TextValidationStatus.TOO_SHORT, false)
    )

    override val isAllValid: Boolean
        get() = searchText.status == TextValidationStatus.CORRECT
}
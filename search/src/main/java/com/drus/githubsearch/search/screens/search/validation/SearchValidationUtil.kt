package com.drus.githubsearch.search.screens.search.validation

import com.drus.githubsearch.core.utils.validationUtil.PropertyValidationStatus
import com.drus.githubsearch.core.utils.validationUtil.ValidationUtil
import com.drus.githubsearch.search.utils.TextValidationStatus
import javax.inject.Inject

class SearchValidationUtil @Inject constructor(): ValidationUtil<String, SearchValidationStatus>() {

    override val defaultValidationStatus: SearchValidationStatus
        get() = SearchValidationStatus()

    fun validateSearchText(text: String, showError: Boolean) {
        validationStatus = validationStatus.copy(searchText = PropertyValidationStatus(
            if (text.length < MIN_TEXT_LENGTH) {
                TextValidationStatus.TOO_SHORT
            } else {
                TextValidationStatus.CORRECT
            }, showError
        ))
    }

    override fun getValidationStatus(item: String, showError: Boolean): SearchValidationStatus {
        return validationStatus.copy(searchText = PropertyValidationStatus(
            if (item.length < MIN_TEXT_LENGTH) {
                TextValidationStatus.TOO_SHORT
            } else {
                TextValidationStatus.CORRECT
            }, showError
        ))
    }

    private companion object {
        const val MIN_TEXT_LENGTH = 2
    }
}
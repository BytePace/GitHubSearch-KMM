package com.drus.githubsearch.mvvm.presentation.view.inputLayout

interface ErrorShowingView {
    fun showError(text: String? = null)
    fun hideError()
}
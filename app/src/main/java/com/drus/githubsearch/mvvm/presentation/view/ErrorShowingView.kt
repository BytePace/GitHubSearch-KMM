package com.drus.githubsearch.mvvm.presentation.view

interface ErrorShowingView {
    fun showError(text: String? = null)
    fun hideError()
}
package com.drus.githubsearch.search.view

interface ErrorShowingView {
    fun showError(text: String? = null)
    fun hideError()
}
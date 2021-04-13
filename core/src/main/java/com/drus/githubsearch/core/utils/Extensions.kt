package com.drus.githubsearch.core.utils

import android.content.Context
import android.view.inputmethod.InputMethodManager

@Suppress("UNCHECKED_CAST", "EXTENSION_SHADOWED_BY_MEMBER")
fun <T> Context.getSystemService(id: String): T {
    return getSystemService(id) as T
}
package com.drus.githubsearch.core.navigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import ru.terrakok.cicerone.android.support.FragmentParams
import ru.terrakok.cicerone.android.support.SupportAppScreen

class BaseScreen(
    private val fragment: Fragment,
    private val args: Bundle? = null
) : SupportAppScreen() {
    override fun getFragment() = fragment
    override fun getFragmentParams() = FragmentParams(fragment::class.java, args)
}
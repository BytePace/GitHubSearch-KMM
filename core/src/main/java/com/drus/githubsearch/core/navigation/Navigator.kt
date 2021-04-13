package com.drus.githubsearch.core.navigation

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import ru.terrakok.cicerone.android.support.SupportAppNavigator
import ru.terrakok.cicerone.commands.Command
import ru.terrakok.cicerone.commands.Forward

class Navigator(
    activity: AppCompatActivity,
    containerID: Int,
    private val changeScreenCallback: ((Int) -> Unit)? = null
) : SupportAppNavigator(activity, containerID) {

    override fun setupFragmentTransaction(
        command: Command,
        currentFragment: Fragment?,
        nextFragment: Fragment?,
        fragmentTransaction: FragmentTransaction
    ) {
        super.setupFragmentTransaction(
            command, currentFragment, nextFragment,
            fragmentTransaction.setTransition(
                if (command is Forward)
                    FragmentTransaction.TRANSIT_FRAGMENT_OPEN
                else
                    FragmentTransaction.TRANSIT_FRAGMENT_CLOSE
            )
        )
    }

    override fun applyCommands(commands: Array<out Command>) {
        super.applyCommands(commands)
        changeScreenCallback?.invoke(stackCount)
    }

    val stackCount: Int
        get() = try {
            localStackCopy.size + 1
        } catch (e: Exception) {
            fragmentManager.backStackEntryCount + 1
        }
}
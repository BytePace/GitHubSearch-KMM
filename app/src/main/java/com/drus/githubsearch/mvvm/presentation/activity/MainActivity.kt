package com.drus.githubsearch.mvvm.presentation.activity

import android.os.Bundle
import android.view.WindowManager
import android.widget.EditText
import androidx.activity.viewModels
import com.drus.githubsearch.core.navigation.Navigator
import com.drus.githubsearch.core.utils.ViewModelFactory
import com.drus.githubsearch.mvvm.R
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {
    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val viewModel by viewModels<MainViewModel> { viewModelFactory }

    private val navigator by lazy {
        Navigator(this, R.id.fragment_container) {
            closeKeyboard()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    @Suppress("DEPRECATION")
    override fun onResume() {
        super.onResume()
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE)
        viewModel.initKeyboardHandler(this)
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        viewModel.setNavigator(navigator)
    }

    override fun onPause() {
        super.onPause()
        viewModel.detach()
    }

    fun closeKeyboard() {
        viewModel.closeKeyboard(
            findViewById(R.id.fragment_container)
        )
    }

    fun showKeyboard(view: EditText) {
        viewModel.showKeyboard(view)
    }
}
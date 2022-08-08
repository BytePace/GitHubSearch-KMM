package com.drus.githubsearch.search.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.annotation.CallSuper
import androidx.annotation.LayoutRes
import androidx.annotation.StringRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import androidx.lifecycle.lifecycleScope
import com.drus.githubsearch.search.BR
import com.drus.githubsearch.search.activity.MainActivity
import dagger.android.support.DaggerFragment
import kotlinx.coroutines.CoroutineScope

abstract class BaseFragment<VM : ViewModel, B : ViewDataBinding>(
    @LayoutRes private val layoutId: Int,
    private val viewModelID: Int? = BR.viewModel
) : DaggerFragment() {
    protected val mainActivity: MainActivity
        get() = requireActivity() as MainActivity

    protected val fragmentScope: CoroutineScope
        get() = viewLifecycleOwner.lifecycleScope

    protected lateinit var binding: B
    protected abstract val viewModel: VM

    private var toast: Toast? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, layoutId, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        configureBinding()
        return binding.root
    }

    @CallSuper
    protected open fun configureBinding() {
        viewModelID?.let {
            binding.setVariable(it, viewModel)
        }
    }

    fun showToast(text: String, duration: Int = Toast.LENGTH_SHORT) {
        toast?.cancel()
        toast = Toast.makeText(requireContext(), text, duration)
        toast?.show()
    }

    fun showToast(@StringRes text: Int, duration: Int = Toast.LENGTH_SHORT) {
        toast?.cancel()
        toast = Toast.makeText(requireContext(), text, duration)
        toast?.show()
    }

    fun closeKeyboard() {
        mainActivity.closeKeyboard()
    }

    fun showKeyboard(view: EditText) {
        mainActivity.showKeyboard(view)
    }

    protected fun forceRefresh() {
        parentFragmentManager
            .beginTransaction()
            .detach(this)
            .attach(this)
            .commit()
    }

    protected fun addOnBackPressedCallback(callback: (MainActivity) -> Unit) {
        activity?.onBackPressedDispatcher?.addCallback(
            viewLifecycleOwner,
            object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    callback(mainActivity)
                }
            })
    }
}
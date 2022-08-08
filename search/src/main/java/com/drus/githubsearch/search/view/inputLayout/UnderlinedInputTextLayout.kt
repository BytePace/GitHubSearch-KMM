package com.drus.githubsearch.search.view.inputLayout

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import androidx.core.content.withStyledAttributes
import androidx.core.view.isVisible
import androidx.core.widget.addTextChangedListener
import androidx.databinding.adapters.TextViewBindingAdapter
import com.drus.githubsearch.search.R
import com.drus.githubsearch.search.databinding.UnderlinedInputLayoutBinding
import com.drus.githubsearch.search.view.ErrorShowingView

class UnderlinedInputTextLayout @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr), ErrorShowingView {

    private val viewBinding =
        UnderlinedInputLayoutBinding.inflate(LayoutInflater.from(context), this)

    init {
        orientation = VERTICAL
        initAttributes(attrs)
        initView()
    }

    private val isErrorEnabled: Boolean
        get() = viewBinding.errorTextView.isVisible

    private fun initAttributes(attrs: AttributeSet?) = with(viewBinding) {
        if (attrs == null) return
        context.withStyledAttributes(attrs, R.styleable.UnderlinedInputTextLayout, 0, 0) {
            titleTextView.text = getString(R.styleable.UnderlinedInputTextLayout_titleText)
            editText.setText(getString(R.styleable.UnderlinedInputTextLayout_editText))
            editText.hint = getString(R.styleable.UnderlinedInputTextLayout_placeholderText)
            //TODO init other attributes
        }
    }

    private fun initView() = with(viewBinding) {
        editText.setOnFocusChangeListener { _, hasFocus ->
            underlineView.isSelected = hasFocus
        }
    }

    override fun hideError() = with(viewBinding.errorTextView) {
        if (!isErrorEnabled) return
        isVisible = false
        text = null
    }

    override fun showError(text: String?) = with(viewBinding.errorTextView) {
        if (text.isNullOrBlank()) {
            hideError()
            return
        }
        isVisible = true
        setText(text)
    }

    @SuppressLint("RestrictedApi")
    fun doAfterTextChanged(action: TextViewBindingAdapter.AfterTextChanged) {
        viewBinding.editText.addTextChangedListener(
            afterTextChanged = action::afterTextChanged
        )
    }
}
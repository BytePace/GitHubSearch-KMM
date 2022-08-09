package com.drus.githubsearch.search.view.inputLayout

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import androidx.core.content.withStyledAttributes
import androidx.core.view.isVisible
import by.kirich1409.viewbindingdelegate.viewBinding
import com.drus.githubsearch.search.R
import com.drus.githubsearch.search.databinding.UnderlinedInputLayoutBinding
import com.drus.githubsearch.search.view.ErrorShowingView

class UnderlinedInputTextLayout @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr), ErrorShowingView {

    private val binding = UnderlinedInputLayoutBinding.inflate(LayoutInflater.from(context), this)
    val editText = binding.editText

    init {
        orientation = VERTICAL
        initAttributes(attrs)
        initView()
    }

    private val isErrorEnabled: Boolean
        get() = binding.errorTextView.isVisible

    private fun initAttributes(attrs: AttributeSet?) = with(binding) {
        if (attrs == null) return
        context.withStyledAttributes(attrs, R.styleable.UnderlinedInputTextLayout, 0, 0) {
            titleTextView.text = getString(R.styleable.UnderlinedInputTextLayout_titleText)
            editText.setText(getString(R.styleable.UnderlinedInputTextLayout_editText))
            editText.hint = getString(R.styleable.UnderlinedInputTextLayout_placeholderText)
            //TODO init other attributes
        }
    }

    private fun initView() = with(binding) {
        editText.setOnFocusChangeListener { _, hasFocus ->
            underlineView.isSelected = hasFocus
        }
    }

    override fun hideError() = with(binding.errorTextView) {
        if (!isErrorEnabled) return
        isVisible = false
        text = null
    }

    override fun showError(text: String?) = with(binding.errorTextView) {
        if (text.isNullOrBlank()) {
            hideError()
            return
        }
        isVisible = true
        setText(text)
    }
}
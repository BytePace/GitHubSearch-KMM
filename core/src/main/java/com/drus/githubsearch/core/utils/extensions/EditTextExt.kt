package com.drus.githubsearch.core.utils.extensions

import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText

fun EditText.addTextChangedListener(
    afterTextChanged: ((Editable) -> Unit)?,
    beforeTextChanged: ((p0: CharSequence, p1: Int, p2: Int, p3: Int) -> Unit)?,
    onTextChanged: ((p0: CharSequence, p1: Int, p2: Int, p3: Int) -> Unit)?
) {
    this.addTextChangedListener(object : TextWatcher {
        override fun afterTextChanged(p0: Editable) {
            afterTextChanged?.invoke(p0)
        }

        override fun beforeTextChanged(p0: CharSequence, p1: Int, p2: Int, p3: Int) {
            beforeTextChanged?.invoke(p0, p1, p2, p3)
        }

        override fun onTextChanged(p0: CharSequence, p1: Int, p2: Int, p3: Int) {
            onTextChanged?.invoke(p0, p1, p2, p3)
        }
    })
}

fun EditText.addTextChangedListenerBy(afterTextChanged: ((Editable) -> Unit)) {
    this.addTextChangedListener(
        afterTextChanged = afterTextChanged,
        beforeTextChanged = null,
        onTextChanged = null
    )
}
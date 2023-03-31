package com.drus.githubsearch.search.adapters

import android.graphics.drawable.Drawable
import android.text.Html
import android.text.method.LinkMovementMethod
import android.text.method.PasswordTransformationMethod
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.drus.githubsearch.core.utils.SafeClickListener
import com.drus.githubsearch.search.view.inputLayout.UnderlinedInputTextLayout
import com.google.android.material.textfield.TextInputLayout


fun View.setSafeClickListener(clickListener: View.OnClickListener) {
    val safeClickListener = SafeClickListener(500) {
        clickListener.onClick(it)
    }
    setOnClickListener(safeClickListener)
}


fun TextView.setCustomText(t: String, underlined: Boolean?) {
    text = t.let {
        if (underlined == true) {
            movementMethod = LinkMovementMethod.getInstance()
            Html.fromHtml("<u>$it</u>")
        } else it
    }
}


fun EditText.setTextDots(dots: Boolean) {
    transformationMethod = if (dots) PasswordTransformationMethod() else null
    setSelection(text.length)
}


fun TextView.setTextUnderlined(yes: Boolean) {
    val buf: String = text.toString()
    text = if (yes) {
        movementMethod = LinkMovementMethod.getInstance()
        Html.fromHtml("<u>$buf</u>")
    } else buf
}


fun View.setNotGoneVisibility(visible: Boolean?) {
    visible ?: return
    visibility = if (visible) View.VISIBLE else View.INVISIBLE
}


fun View.bindVisibility(visible: Boolean?) {
    visible ?: return
    visibility = if (visible) View.VISIBLE else View.GONE
}


fun View.bindSelect(selected: Boolean?) {
    selected ?: return
    isSelected = selected
}


fun TextView.setTextColorById(id: Int?) {
    id ?: return
    if (id <= 0) return
    setTextColor(ContextCompat.getColor(context, id))
}

/*@BindingAdapter("app:drawableTint")
fun TextView.setDrawableTint(color: Int) {
    compoundDrawableTintList = ColorStateList.valueOf(color)
    compoundDrawableTintMode = PorterDuff.Mode.SRC_IN
}*/


fun TextView.setDrawables(start: Drawable, top: Drawable, end: Drawable, bottom: Drawable) {
    setCompoundDrawablesWithIntrinsicBounds(start, top, end, bottom)
}

fun TextView.setDrawables(start: Drawable?) {
    setCompoundDrawablesWithIntrinsicBounds(start, null, null, null)
}

fun RecyclerView.setAdapterCustom(adapter: RecyclerView.Adapter<*>) {
    this.adapter = adapter
}

fun View.setClipOutline(flag: Boolean) {
    clipToOutline = flag
}

fun TextInputLayout.setErrorText(errorTextRes: Int?) {
    isErrorEnabled = errorTextRes != null && errorTextRes > 0
    error = errorTextRes?.let(context::getString)
}

fun TextInputLayout.setErrorText(errorText: String?) {
    isErrorEnabled = !errorText.isNullOrEmpty()
    error = errorText
}


fun UnderlinedInputTextLayout.setErrorText(errorTextRes: Int?) {
    showError(errorTextRes?.let(context::getString))
}


fun UnderlinedInputTextLayout.setErrorText(errorText: String?) {
    showError(errorText)
}

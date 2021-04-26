package com.drus.githubsearch.mvvm.presentation.adapters

import android.graphics.drawable.Drawable
import android.text.Html
import android.text.method.LinkMovementMethod
import android.text.method.PasswordTransformationMethod
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.drus.githubsearch.core.utils.SafeClickListener
import com.google.android.material.textfield.TextInputLayout

@BindingAdapter("android:onSafeClick")
fun View.setSafeClickListener(clickListener: View.OnClickListener) {
    val safeClickListener = SafeClickListener(500) {
        clickListener.onClick(it)
    }
    setOnClickListener(safeClickListener)
}

@BindingAdapter("android:text", "android:underlined")
fun TextView.setCustomText(t: String, underlined: Boolean?) {
    text = t.let {
        if (underlined == true) {
            movementMethod = LinkMovementMethod.getInstance()
            Html.fromHtml("<u>$it</u>")
        } else it
    }
}

@BindingAdapter("android:textDots")
fun EditText.setTextDots(dots: Boolean) {
    transformationMethod = if (dots) PasswordTransformationMethod() else null
    setSelection(text.length)
}

@BindingAdapter("android:underlined")
fun TextView.setTextUnderlined(yes: Boolean) {
    val buf: String = text.toString()
    text = if (yes) {
        movementMethod = LinkMovementMethod.getInstance()
        Html.fromHtml("<u>$buf</u>")
    } else buf
}

@BindingAdapter("android:notGoneVisibility")
fun View.setNotGoneVisibility(visible: Boolean?) {
    visible ?: return
    visibility = if (visible) View.VISIBLE else View.INVISIBLE
}

@BindingAdapter("android:visibility")
fun View.bindVisibility(visible: Boolean?) {
    visible ?: return
    visibility = if (visible) View.VISIBLE else View.GONE
}

@BindingAdapter("android:selected")
fun View.bindSelect(selected: Boolean?) {
    selected ?: return
    isSelected = selected
}

@BindingAdapter("android:textColorId")
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

@BindingAdapter(
    "app:drawableStartCompat",
    "app:drawableTopCompat",
    "app:drawableEndCompat",
    "app:drawableBottomCompat"
)
fun TextView.setDrawables(start: Drawable, top: Drawable, end: Drawable, bottom: Drawable) {
    setCompoundDrawablesWithIntrinsicBounds(start, top, end, bottom)
}

@BindingAdapter("app:drawableStartCompat")
fun TextView.setDrawables(start: Drawable?) {
    setCompoundDrawablesWithIntrinsicBounds(start, null, null, null)
}

@BindingAdapter("android:adapter")
fun RecyclerView.setAdapterCustom(adapter: RecyclerView.Adapter<*>) {
    this.adapter = adapter
}

@BindingAdapter("android:clipToOutline")
fun View.setClipOutline(flag: Boolean) {
    clipToOutline = flag
}

@BindingAdapter("app:errorTextRes")
fun TextInputLayout.setErrorText(errorTextRes: Int?) {
    isErrorEnabled = errorTextRes != null && errorTextRes > 0
    error = errorTextRes?.let(context::getString)
}

@BindingAdapter("app:errorText")
fun TextInputLayout.setErrorText(errorTextRes: String?) {
    isErrorEnabled = !errorTextRes.isNullOrEmpty()
    error = errorTextRes
}

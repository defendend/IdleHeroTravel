package com.defendend.idleherotravel.utils

import android.graphics.drawable.Drawable
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.annotation.AttrRes
import androidx.annotation.ColorInt
import androidx.annotation.ColorRes
import androidx.annotation.DimenRes
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.content.ContextCompat

fun View.drawable(@DrawableRes res: Int): Drawable? {
    return AppCompatResources.getDrawable(context, res)
}

fun View.dimen(@DimenRes res: Int): Int {
    return context.resources.getDimension(res).toInt()
}

fun View.string(@StringRes res: Int): String {
    return context.getString(res)
}

@ColorInt
fun View.color(@ColorRes res: Int): Int {
    return context.getColor(res)
}

@ColorInt
fun View.attrColor(@AttrRes res: Int): Int {
    return context.attrColor(res)
}

fun View.hideKeyboard() {
    val inputMethodManager = ContextCompat.getSystemService(context, InputMethodManager::class.java)
    inputMethodManager?.hideSoftInputFromWindow(windowToken, 0)
}

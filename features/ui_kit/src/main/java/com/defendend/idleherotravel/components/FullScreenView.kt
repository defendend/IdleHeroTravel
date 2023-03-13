package com.defendend.idleherotravel.components

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.viewbinding.ViewBinding
import com.defendend.idleherotravel.ui_kit.R
import com.defendend.idleherotravel.utils.attrColor

@SuppressLint("ClickableViewAccessibility")
@Suppress("LeakingThis")
abstract class FullScreenView<Binding: ViewBinding>(context: Context): FrameLayout(context) {

// MARK: - Properties

    protected val binding: Binding

// MARK: - Construction

    init {
        binding = bindingFactory(LayoutInflater.from(context), this)
        binding.root.setBackgroundColor(attrColor(R.attr.component_background))

        addView(binding.root)

        setOnTouchListener { _, _ -> true }
    }

// MARK: - Methods

    abstract fun bindingFactory(inflater: LayoutInflater, parent: ViewGroup): Binding
}

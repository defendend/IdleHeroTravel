package com.defendend.idleherotravel.views

import android.content.Context
import android.util.AttributeSet
import android.view.View
import com.defendend.idleherotravel.di.koin.R
import com.defendend.idleherotravel.utils.dimen
import com.defendend.idleherotravel.utils.drawable

class SliderLineView @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
): View(context, attributeSet) {

// MARK: - Construction

    init {
        background = drawable(R.drawable.slider_view_background)
    }

// MARK: - Methods

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        setMeasuredDimension(widthSize, heightSize)
    }

// MARK: - Variables

    private val heightSize = dimen(R.dimen.component_slider_height)
    private val widthSize = dimen(R.dimen.component_slider_width)
}

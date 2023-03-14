package com.defendend.idleherotravel.views

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import com.defendend.idleherotravel.ui.kit.R

class ShadowView @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
): View(context, attributeSet) {

// MARK: - Methods

    override fun onDraw(canvas: Canvas) {
        canvas.drawRect(0f,0f,width.toFloat(),height.toFloat(), paint)
    }

// MARK: - Variables

    private val paint = Paint().apply {
        color = context.getColor(R.color.shadow_color)
    }
}

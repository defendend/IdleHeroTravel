package com.defendend.idleherotravel.components

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.LinearLayout
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.view.children
import androidx.core.view.updateLayoutParams
import androidx.viewbinding.ViewBinding
import com.defendend.idleherotravel.ui_kit.R
import com.defendend.idleherotravel.utils.drawable
import com.defendend.idleherotravel.utils.hideKeyboard
import com.defendend.idleherotravel.views.ShadowView
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback

abstract class BottomView<Binding: ViewBinding>(context: Context): FrameLayout(context) {

// MARK: - Properties

    protected val binding: Binding by lazy {
        bindingFactory(
            LayoutInflater.from(context),
            bottomLayout
        )
    }

    protected open val isHideable get() = true

// MARK: - Construction

    init {
        initContent()
        fitsSystemWindows = true
    }

// MARK: - Methods

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        bottomLayout.addOnLayoutChangeListener(cardLayoutListener)
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        bottomLayout.removeOnLayoutChangeListener(cardLayoutListener)
        dismissListeners.clear()
    }

    fun addDismissListener(listener: () -> Unit) {
        dismissListeners += listener
    }

    fun removeDismissListener(listener: () -> Unit) {
        dismissListeners -= listener
    }

    fun dismiss() {
        bottomCallback.onDismissManually()
        setState(BottomSheetBehavior.STATE_HIDDEN)
    }

    abstract fun bindingFactory(inflater: LayoutInflater, parent: ViewGroup): Binding

    protected fun setState(state: Int) {
        bottomSheetBehavior.state = state
    }

// MARK: - Private Methods

    @SuppressLint("ClickableViewAccessibility")
    private fun initContent() {
        inflate(context, R.layout.layout_bottom_view, this)

        bottomLayout.updateLayoutParams<CoordinatorLayout.LayoutParams> {
            behavior = bottomSheetBehavior
        }
        bottomLayout.setOnTouchListener { _, _ -> true }
        shadowView.setOnClickListener {
            if (isHideable) {
                dismiss()
            }
        }

        initBottomSheet()
    }

    @SuppressLint("ClickableViewAccessibility")
    private fun initBottomSheet() {
        bottomLayout.addView(
            binding.root,
            LayoutParams.MATCH_PARENT,
            LayoutParams.MATCH_PARENT,
        )
        binding.root.background = drawable(R.drawable.bottom_view_background)

        initBottomSheetState()
    }

    private fun initBottomSheetState() {
        val anchor = findAnchorBottom(0f, bottomLayout)
        bottomSheetBehavior.isFitToContents = (anchor == null)

        val state = when (anchor) {
            null -> BottomSheetBehavior.STATE_EXPANDED
            else -> BottomSheetBehavior.STATE_HALF_EXPANDED
        }

        post { setState(state) }
    }

    private fun findAnchorBottom(currY: Float, viewGroup: ViewGroup): Float? {
        var anchorBottom: Float? = null

        viewGroup.children.forEach { view ->

            if (view.tag == ANCHOR_TAG) {
                anchorBottom = currY + view.y + view.measuredHeight
            }

            if (view is ViewGroup) {
                val newY = currY + view.y
                anchorBottom = findAnchorBottom(currY = newY, view)
            }

            if (anchorBottom != null) {
                return@forEach
            }
        }

        return anchorBottom
    }

// MARK: - Inner Types

    inner class BottomCallBack: BottomSheetCallback() {

        fun onDismissManually() {
            hiddenManually = true
        }

        override fun onSlide(bottomSheet: View, slideOffset: Float) {
            shadowView.alpha = 1 + slideOffset
        }

        override fun onStateChanged(bottomSheet: View, newState: Int) {
            val isHidden = newState == BottomSheetBehavior.STATE_HIDDEN
            val shouldHide = isHidden && (isHideable || hiddenManually)

            when {
                shouldHide -> {
                    hideKeyboard()
                    val listeners = dismissListeners.toList()
                    listeners.forEach { it.invoke() }
                }

                isHidden -> setState(BottomSheetBehavior.STATE_EXPANDED)
            }
        }

        private var hiddenManually = false
    }

// MARK: - Companion

    companion object {
        const val ANCHOR_TAG = "ANCHOR"
    }

// MARK: - Variables

    private val shadowView: ShadowView by lazy { findViewById(R.id.shadowView) }

    private val bottomLayout: LinearLayout by lazy { findViewById(R.id.bottom_layout) }

    private val bottomCallback = BottomCallBack()

    private val bottomSheetBehavior = BottomSheetBehavior<LinearLayout>(context, null).apply {
        isHideable = true
        skipCollapsed = true
        state = BottomSheetBehavior.STATE_HIDDEN
        addBottomSheetCallback(bottomCallback)
    }

    private val dismissListeners = mutableListOf<(() -> Unit)>()

    private val cardLayoutListener = OnLayoutChangeListener { _, _, _, _, _, _, _, _, _ ->
        val anchorBottom = findAnchorBottom(currY = 0f, viewGroup = bottomLayout)
        if (anchorBottom != null) {
            bottomSheetBehavior.halfExpandedRatio = anchorBottom / measuredHeight
        }
    }
}

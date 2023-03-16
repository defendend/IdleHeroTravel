package com.defendend.idleherotravel.navigation

import com.defendend.idleherotravel.abstraction.IViewBackstackController
import java.util.LinkedList

class ViewBackstackController: IViewBackstackController {

// MARK: - Methods

    override fun addViewFactory(factory: ViewFactory<*>) {
        when (factory) {
            is BottomViewFactory -> {
                val layer = createLayer()
                layer.bottomViewStack.add(factory)
            }
            is FullScreenViewFactory -> {
                val layer = createLayer()
                layer.fullScreenViewStack.add(factory)
            }
            else -> {
                val snapshot = LayerSnapshot(viewFactory = factory)
                viewStack.add(snapshot)
            }
        }
    }

    override fun currentViewFactory(): ViewFactory<*>? {
        return actualLayer?.viewFactory
    }

    override fun currentBottomViewFactory(): BottomViewFactory? {
        return actualLayer?.bottomViewStack?.lastOrNull()
    }

    override fun currentFullScreenViewFactory(): FullScreenViewFactory? {
        return actualLayer?.fullScreenViewStack?.lastOrNull()
    }

    override fun popView() {
        if (actualLayer != null) {
            viewStack.removeLast()
        }
    }

    override fun popBottomView() {
        val layer = actualLayer
        if (layer != null && layer.bottomViewStack.isNotEmpty()) {
            layer.bottomViewStack.removeLast()
        }
    }

    override fun popFullScreenView() {
        val layer = actualLayer
        if (layer != null && layer.fullScreenViewStack.isNotEmpty()) {
            layer.fullScreenViewStack.removeLast()
        }
    }

// MARK: - Private Methods

    private fun createLayer(): LayerSnapshot {
        return actualLayer ?: run {
            val layer = LayerSnapshot()
            viewStack.add(layer)
            layer
        }
    }

// MARK: - Inner Types

    private class LayerSnapshot(
        val viewFactory: ViewFactory<*>? = null,
        val bottomViewStack: MutableList<BottomViewFactory> = mutableListOf(),
        val fullScreenViewStack: MutableList<FullScreenViewFactory> = mutableListOf(),
    )

// MARK: - Variables

    private val viewStack = LinkedList<LayerSnapshot>()

    private val actualLayer: LayerSnapshot?
        get() = viewStack.lastOrNull()
}

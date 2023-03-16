package com.defendend.idleherotravel.navigation

import android.view.View
import com.defendend.idleherotravel.components.BottomView
import com.defendend.idleherotravel.components.FullScreenView

sealed interface ViewFactory<T: View> {

// MARK: - Methods

    fun create(): T
}

interface BaseViewFactory: ViewFactory<View>

interface BottomViewFactory: ViewFactory<BottomView<*>>

interface FullScreenViewFactory: ViewFactory<FullScreenView<*>>

fun viewFactory(factory: () -> View): BaseViewFactory {

    val viewFactory = object: BaseViewFactory {
        override fun create(): View {
            return factory.invoke()
        }
    }

    return viewFactory
}

fun bottomViewFactory(factory: () -> BottomView<*>): BottomViewFactory {

    val viewFactory = object: BottomViewFactory {
        override fun create(): BottomView<*> {
            return factory.invoke()
        }
    }

    return viewFactory
}

fun fullScreenViewFactory(factory: () -> FullScreenView<*>): FullScreenViewFactory {

    val viewFactory = object: FullScreenViewFactory {
        override fun create(): FullScreenView<*> {
            return factory.invoke()
        }
    }

    return viewFactory
}


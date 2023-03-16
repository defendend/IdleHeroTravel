package com.defendend.idleherotravel.abstraction

import android.view.View
import com.defendend.idleherotravel.navigation.BottomViewFactory
import com.defendend.idleherotravel.navigation.FullScreenViewFactory
import com.defendend.idleherotravel.navigation.ViewFactory

interface IViewRouter {

// MARK: - Methods

    fun onStart()

    fun onStop()

    fun showBottomView(factory: () -> View)

    fun showFullScreen(factory: () -> View)

    fun popView()

    fun popBottomView()

    fun onBottomViewDismiss()

    fun replaceCurrentView(viewFactory: ViewFactory<*>?)

    fun replaceBottomView(viewFactory: BottomViewFactory?)

    fun replaceFullScreenView(viewFactory: FullScreenViewFactory?)
}
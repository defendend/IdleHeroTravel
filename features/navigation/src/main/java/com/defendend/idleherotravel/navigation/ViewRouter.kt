package com.defendend.idleherotravel.navigation

import android.view.View
import android.view.ViewGroup
import com.defendend.idleherotravel.abstraction.IViewBackstackController
import com.defendend.idleherotravel.abstraction.IViewRouter
import com.defendend.idleherotravel.components.BottomView
import com.defendend.idleherotravel.components.FullScreenView

class ViewRouter(
    private val viewBackstackController: IViewBackstackController,
    private val rootView: ViewGroup,
): IViewRouter {

// MARK: - Methods

    override fun onStart() {

        val factory = viewBackstackController.currentViewFactory()
        val bottomFactory = viewBackstackController.currentBottomViewFactory()
        val fullScreenFactory = viewBackstackController.currentFullScreenViewFactory()

        replaceCurrentView(viewFactory = factory)
        replaceBottomView(viewFactory = bottomFactory)
        replaceFullScreenView(viewFactory = fullScreenFactory)
    }

    override fun onStop() {
        replaceCurrentView(viewFactory = null)
        replaceBottomView(viewFactory = null)
        replaceFullScreenView(viewFactory = null)
    }

    override fun showBottomView(factory: () -> View) {
        TODO("Not yet implemented")
    }

    override fun showFullScreen(factory: () -> View) {
        TODO("Not yet implemented")
    }

    override fun popView() {
        TODO("Not yet implemented")
    }

    override fun popBottomView() {
        TODO("Not yet implemented")
    }

    override fun onBottomViewDismiss() {
        TODO("Not yet implemented")
    }

    override fun replaceCurrentView(viewFactory: ViewFactory<*>?) {
        TODO("Not yet implemented")
    }

    override fun replaceBottomView(viewFactory: BottomViewFactory?) {
        TODO("Not yet implemented")
    }

    override fun replaceFullScreenView(viewFactory: FullScreenViewFactory?) {
        TODO("Not yet implemented")
    }

// MARK: - Variables

    private var _currentView: View? = null
    private var _currentBottomView: BottomView<*>? = null
    private var _currentFullScreenView: FullScreenView<*>? = null

    private val _defaultDismissListener = {
        onBottomViewDismiss()
    }
}
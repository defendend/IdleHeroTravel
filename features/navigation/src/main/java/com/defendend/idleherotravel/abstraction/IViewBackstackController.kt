package com.defendend.idleherotravel.abstraction

import com.defendend.idleherotravel.navigation.BottomViewFactory
import com.defendend.idleherotravel.navigation.FullScreenViewFactory
import com.defendend.idleherotravel.navigation.ViewFactory

interface IViewBackstackController {

// MARK: - Methods

    fun addViewFactory(factory: ViewFactory<*>)

    fun currentViewFactory(): ViewFactory<*>?

    fun currentBottomViewFactory(): BottomViewFactory?

    fun currentFullScreenViewFactory(): FullScreenViewFactory?

    fun popView()

    fun popBottomView()

    fun popFullScreenView()
}
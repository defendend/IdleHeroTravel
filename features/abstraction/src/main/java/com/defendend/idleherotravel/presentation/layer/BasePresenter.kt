package com.defendend.idleherotravel.presentation.layer

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel

abstract class BasePresenter<View: MvpView> {

// MARK: - Properties

    protected val mainScope: CoroutineScope?
        get() = _mainScope

    protected val mvpView: View?
        get() = _mvpView

// MARK: - Methods

    fun attach(view: View) {
        if (_mvpView == null) {
            _mainScope = CoroutineScope(Dispatchers.Main)
            _mvpView = view
            onAttach()
        }
    }

    fun detach() {
        onDetach()
        _mainScope?.cancel("Presenter detached")
        _mvpView = null
    }

    protected open fun onAttach() = Unit
    protected open fun onDetach() = Unit

// MARK: - Variables

    private var _mainScope: CoroutineScope? = null
    private var _mvpView: View? = null
}

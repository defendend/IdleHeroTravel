package com.defendend.idleherotravel.presentation.game

import com.defendend.idleherotravel.presentation.layer.BasePresenter
import kotlinx.coroutines.launch

class GamePresenter: BasePresenter<IGameMvpView>() {

// MARK: - Methods

    override fun onAttach() {
        super.onAttach()
        mainScope?.launch {

        }
    }
}
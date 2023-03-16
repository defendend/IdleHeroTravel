package com.defendend.idleherotravel.presentation.game

import com.defendend.idleherotravel.models.presentation.GameState
import com.defendend.idleherotravel.presentation.layer.MvpView

interface IGameMvpView: MvpView {

// MARK: - Methods

    fun render(state: GameState)
}

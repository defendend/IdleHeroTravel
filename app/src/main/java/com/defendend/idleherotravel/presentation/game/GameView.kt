package com.defendend.idleherotravel.presentation.game

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import com.defendend.idleherotravel.components.FullScreenView
import com.defendend.idleherotravel.databinding.LayoutGameScreenBinding
import com.defendend.idleherotravel.models.presentation.GameState

@SuppressLint("ViewConstructor")
class GameView(
    context: Context,
    presenter: GamePresenter,
): FullScreenView<LayoutGameScreenBinding>(context), IGameMvpView {

// MARK: - Methods

    override fun bindingFactory(inflater: LayoutInflater, parent: ViewGroup): LayoutGameScreenBinding {
        return LayoutGameScreenBinding.inflate(inflater, parent, false)
    }

    override fun render(state: GameState) {
        when (state) {
            else -> throw IllegalStateException("State is not supported.")
        }
    }

// MARK: - Variables

    private val _presenter: GamePresenter = presenter
}

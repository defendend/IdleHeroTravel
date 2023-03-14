package com.defendend.idleherotravel.app

import android.app.Application
import com.defendend.idleherotravel.di.koin.ApplicationKoinContainer
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class IdleHeroTravelApplication: Application() {

// MARK: - Methods

    override fun onCreate() {
        super.onCreate()

        initKoin()
    }

// MARK: - Private Methods

    private fun initKoin() {
        startKoin {
            androidContext(this@IdleHeroTravelApplication)
        }
        ApplicationKoinContainer.loadBootScopeModules()
    }
}
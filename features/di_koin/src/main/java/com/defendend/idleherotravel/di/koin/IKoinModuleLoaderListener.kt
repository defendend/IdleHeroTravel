package com.defendend.idleherotravel.di.koin

interface IKoinModuleLoaderListener {

// MARK: - Methods: Boot Scope

    fun onBeforeLoadBootScopeModules() {
        // Do nothing
    }

    fun onAfterLoadBootScopeModules() {
        // Do nothing
    }

    fun onBeforeUnloadBootScopeModules() {
        // Do nothing
    }

    fun onAfterUnloadBootScopeModules() {
        // Do nothing
    }

// MARK: - Methods: User Scope

    fun onBeforeLoadUserScopeModules() {
        // Do nothing
    }

    fun onAfterLoadUserScopeModules() {
        // Do nothing
    }

    fun onBeforeUnloadUserScopeModules() {
        // Do nothing
    }

    fun onAfterUnloadUserScopeModules() {
        // Do nothing
    }
}

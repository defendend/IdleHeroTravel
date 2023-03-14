package com.defendend.idleherotravel.di.koin

interface IKoinModuleLoader {

// MARK: - Methods

    fun loadBootScopeModules()

    fun unloadBootScopeModules()

    fun loadUserScopeModules()

    fun unloadUserScopeModules()
}

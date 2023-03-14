package com.defendend.idleherotravel.di.koin

import org.koin.core.module.Module

interface IKoinModuleBundle {

// MARK: - Properties

    val bootScopeModule: Module?
        get() = null

    val userScopeModule: Module?
        get() = null
}

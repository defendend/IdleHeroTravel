@file:Suppress("RemoveExplicitTypeArguments")

package com.defendend.idleherotravel.di.koin.module

import com.defendend.idleherotravel.di.koin.IKoinModuleBundle
import org.koin.dsl.module

internal object ViewRouterBundle: IKoinModuleBundle {

// MARK: - Properties

    override val bootScopeModule = module {
        // Do nothing
    }

    override val userScopeModule = module {
        // Do nothing
    }
}

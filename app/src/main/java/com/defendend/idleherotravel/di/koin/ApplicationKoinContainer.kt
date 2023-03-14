package com.defendend.idleherotravel.di.koin

object ApplicationKoinContainer: AbstractKoinContainer() {

// MARK: - Properties

    override val koinModulesBundles: List<IKoinModuleBundle> = listOf()

    override val koinModuleLoaders: List<IKoinModuleLoader> = listOf()
}
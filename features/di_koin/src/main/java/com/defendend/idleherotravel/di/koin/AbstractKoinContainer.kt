package com.defendend.idleherotravel.di.koin

import org.koin.core.context.loadKoinModules
import org.koin.core.context.unloadKoinModules
import java.util.concurrent.atomic.AtomicBoolean

abstract class AbstractKoinContainer: IKoinModuleLoader {

// MARK: - Properties

    protected abstract val koinModulesBundles: List<IKoinModuleBundle>

    protected open val koinModuleLoaders: List<IKoinModuleLoader> = emptyList()

// MARK: - Methods

    override fun loadBootScopeModules() {
        if (_bootScopeLoader.compareAndSet(false, true)) {

            if (this is IKoinModuleLoaderListener) {
                onBeforeLoadBootScopeModules()
            }

            this.koinModuleLoaders.forEach { loader ->
                loader.loadBootScopeModules()
            }

            this.koinModulesBundles.forEach { bundle ->
                bundle.bootScopeModule?.let { module ->
                    loadKoinModules(module)
                }
            }

            if (this is IKoinModuleLoaderListener) {
                onAfterLoadBootScopeModules()
            }
        }
    }

    override fun unloadBootScopeModules() {
        if (_bootScopeLoader.get()) {

            unloadUserScopeModules()

            if (this is IKoinModuleLoaderListener) {
                onBeforeUnloadBootScopeModules()
            }

            this.koinModulesBundles.reversed().forEach { bundle ->
                bundle.bootScopeModule?.let { module ->
                    unloadKoinModules(module)
                }
            }

            this.koinModuleLoaders.reversed().forEach { loader ->
                loader.unloadBootScopeModules()
            }

            _bootScopeLoader.set(false)

            if (this is IKoinModuleLoaderListener) {
                onAfterUnloadBootScopeModules()
            }
        }
    }

    override fun loadUserScopeModules() {
        if (_userScopeLoader.compareAndSet(false, true)) {

            loadBootScopeModules()

            if (this is IKoinModuleLoaderListener) {
                onBeforeLoadUserScopeModules()
            }

            this.koinModuleLoaders.forEach { loader ->
                loader.loadUserScopeModules()
            }

            this.koinModulesBundles.forEach { bundle ->
                bundle.userScopeModule?.let { module ->
                    loadKoinModules(module)
                }
            }

            if (this is IKoinModuleLoaderListener) {
                onAfterLoadUserScopeModules()
            }
        }
    }

    override fun unloadUserScopeModules() {
        if (_userScopeLoader.get()) {

            if (this is IKoinModuleLoaderListener) {
                onBeforeUnloadUserScopeModules()
            }

            this.koinModulesBundles.reversed().forEach { bundle ->
                bundle.userScopeModule?.let { module ->
                    unloadKoinModules(module)
                }
            }

            this.koinModuleLoaders.reversed().forEach { loader ->
                loader.unloadUserScopeModules()
            }

            _userScopeLoader.set(false)

            if (this is IKoinModuleLoaderListener) {
                onAfterUnloadBootScopeModules()
            }
        }
    }

// MARK: - Variables

    private val _bootScopeLoader = AtomicBoolean(false)
    private val _userScopeLoader = AtomicBoolean(false)
}

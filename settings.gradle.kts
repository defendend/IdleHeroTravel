pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}
rootProject.name = "Idle Hero Travel"
include(":app")
include(":features:abstraction")
include(":features:di_koin")
include(":features:navigation")
include(":features:ui_kit")

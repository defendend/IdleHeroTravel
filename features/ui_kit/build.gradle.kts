plugins {
    id(PluginId.android)
    id(PluginId.kotlin_android)
}

android {
    compileSdk = AppConfig.compileSdk
    buildToolsVersion = AppConfig.buildTools

    defaultConfig {
        minSdk = AppConfig.minSdk
        targetSdk = AppConfig.targetSdk
    }
}

dependencies {

    implementation(Libs.material)
}
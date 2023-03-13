object Module {

    const val uiKit = ":features:ui_kit"
}

object PluginId {
    const val application = "com.android.application"
    const val android = "com.android.library"
    const val jetbrains_kotlin = "org.jetbrains.kotlin.android"
    const val serialization = "org.jetbrains.kotlin.plugin.serialization"
    const val jvm = "org.jetbrains.kotlin.jvm"
    const val kotlin_android = "kotlin-android"
}

object Libs {

    const val core_ktx = "androidx.core:core-ktx:${Versions.core_ktx}"
    const val appcompat = "androidx.appcompat:appcompat:1.6.1"
    const val material = "com.google.android.material:material:${Versions.material}"
    const val constraintlayout = "androidx.constraintlayout:constraintlayout:2.1.4"

    const val junit = "junit:junit:4.13.2"
    const val ext_junit = "androidx.test.ext:junit:1.1.5"
    const val espresso_core = "androidx.test.espresso:espresso-core:3.5.1"
}
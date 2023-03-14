object Module {

    const val uiKit = ":features:ui_kit"
    const val diKoin = ":features:di_koin"
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

    const val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"
    const val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
    const val material = "com.google.android.material:material:${Versions.material}"
    const val constraintlayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintlayout}"
    const val koin = "io.insert-koin:koin-android:${Versions.koin}"
    const val junit = "junit:junit:${Versions.junit}"
    const val extJunit = "androidx.test.ext:junit:${Versions.extJunit}"
    const val espressoCore = "androidx.test.espresso:espresso-core:${Versions.espressoCore}"
}
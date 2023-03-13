plugins {
    id(PluginId.application) version "7.4.1" apply false
    id(PluginId.android) version "7.4.1" apply false
    id(PluginId.jetbrains_kotlin) version "1.8.20-RC" apply false
    id(PluginId.serialization) version "1.8.0" apply false
    id(PluginId.jvm) version "1.8.0" apply false
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
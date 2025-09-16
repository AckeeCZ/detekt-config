plugins {
    alias(libs.plugins.detekt)
    alias(libs.plugins.kotlin.jvm)
}

repositories {
    mavenLocal()
    mavenCentral()
}

kotlin {
    jvmToolchain(21)
}

val detektConfig: Configuration by configurations.creating {}

detekt {
    buildUponDefaultConfig = true
    ignoreFailures = false
    config.setFrom(provider { detektConfig.files })
}

dependencies {
    detektPlugins(libs.detekt.formatting)

    @Suppress("unused")
    val configVersion = "1.0.0"
    // Uncomment dependencies for testing changes published to Maven Local
//    detektConfig("io.github.ackeecz:detekt-config-core:$configVersion")
}

import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    `kotlin-dsl`
}

kotlin {
    jvmToolchain(20)
    tasks.withType<KotlinCompile>().configureEach {
        compilerOptions {
            freeCompilerArgs.addAll(
                "-Xexplicit-api=strict",
            )
        }
    }
}

dependencies {
    compileOnly(files(libs::class.java.superclass.protectionDomain.codeSource.location))
    compileOnly(libs.mavenPublish.gradlePlugin)
}

gradlePlugin {
    plugins {
        plugin(
            dependency = libs.plugins.ackeecz.detektconfig.publishing,
            pluginName = "PublishingPlugin",
        )
    }
}

fun NamedDomainObjectContainer<PluginDeclaration>.plugin(
    dependency: Provider<out PluginDependency>,
    pluginName: String,
) {
    val packageName = "io.github.ackeecz.detektconfig"
    val pluginId = dependency.get().pluginId
    register(pluginId) {
        id = pluginId
        implementationClass = "$packageName.plugin.$pluginName"
    }
}

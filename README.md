# Detekt Config
Simple repository that contains Detekt configurations that we share among our projects in Ackee.

## Architecture
The project consists of several modules:
- `core` - contains shared configuration of the standard built-in Detekt rules

## Setup

Add the following dependencies to your `libs.versions.toml`, depending on what you need.

```toml
[versions]
ackee-detekt-config = "SPECIFY_VERSION"

[libraries]
ackee-detekt-config-core = { module = "io.github.ackeecz:detekt-config-core", version.ref = "ackee-detekt-config" }
```

Then in your `build.gradle.kts`:

```kotlin
val detektConfig: Configuration by configurations.creating {}

detekt {
    // The config expects that you have buildUponDefaultConfig set to true.
    buildUponDefaultConfig = true
    // You can set more config files before or after detektConfig.files depending on your needs. The last config for
    // a given rule wins.
    config.setFrom(provider { detektConfig.files })
    ...
}

dependencies {
    detektConfig(libs.ackee.detekt.config.core)
    ...
}
```

## Detekt IDE plugin support
Using shared Detekt config files complicates usage of the Detekt IDE plugin for real time rule violation reports
in the IDE editor, because the files are now library artifacts and are not easily accessible for the plugin. You might
set the path to the file in the Gradle storage of dependencies on your machine, but it is not really robust. You can instead
create a Gradle task that copies the files to your project and set the path there, which is much more robust. For example,
you can add the following code to your Gradle convention plugin, which applies Detekt build logic to all of your modules,
to create a root project task just once and wire it with all Detekt tasks, so it runs automatically whenever you run any
Detekt task, to ensure it is up-to-date. It takes all config files, removes version suffix to keep the file name consistent
between versions and copies them to the root build folder. You can then set the path to these files in the settings
of the Detekt IDE plugin.
```kotlin
private fun Project.registerSetUpDetektConfigsForIdePluginTask(detektConfig: Configuration) {
    val taskName = "setUpDetektConfigsForIdePlugin"
    val rootTasks = rootProject.tasks
    if (rootTasks.find { it.name == taskName } == null) {
        val taskProvider = rootTasks.register<Copy>(taskName) {
            from(provider { detektConfig.files })
            into("$rootDir/build/detektConfigs")
            rename { fileName ->
                val lastDash = fileName.lastIndexOf('-')
                fileName.substring(0, lastDash) + ".yml"
            }
        }
        project.tasks.withType<Detekt>().configureEach {
            dependsOn(taskProvider)
        }
    }
}
```

## Credits

Developed by [Ackee](https://www.ackee.cz) team with 💙.

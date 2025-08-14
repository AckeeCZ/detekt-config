package io.github.ackeecz.detektconfig.util

internal sealed interface PublishableProject {

    val projectName: String

    object Core : PublishableProject {

        override val projectName = "core"
    }
}

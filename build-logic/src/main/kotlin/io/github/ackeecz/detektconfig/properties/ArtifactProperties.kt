package io.github.ackeecz.detektconfig.properties

import io.github.ackeecz.detektconfig.util.PublishableProject
import java.util.Properties

public sealed class ArtifactProperties(
    private val properties: Properties,
    private val defaultPropertyPrefix: String,
) {

    public val id: String = getPropertyWithDefaultPrefix("ARTIFACT_ID")
    public val pomName: String = getPropertyWithDefaultPrefix("POM_NAME")
    public val pomYear: String = getPropertyWithDefaultPrefix("POM_YEAR")
    public val pomDescription: String = getPropertyWithDefaultPrefix("POM_DESCRIPTION")

    private fun getPropertyWithDefaultPrefix(name: String): String {
        return getProperty(prefix = defaultPropertyPrefix, name = name)
    }

    private fun getProperty(prefix: String, name: String): String {
        return properties.getNonNull("${prefix}_$name")
    }

    public class Core(properties: Properties) : ArtifactProperties(
        properties = properties,
        defaultPropertyPrefix = "CORE",
    )

    internal companion object {

        fun getFor(
            projectName: String,
            properties: Properties,
        ): ArtifactProperties = when (projectName) {
            PublishableProject.Core.projectName -> Core(properties)
            else -> throw IllegalStateException("Unknown Gradle module with name $projectName. Please " +
                "add artifact properties for this module and corresponding mapping in " +
                "${ArtifactProperties::class.simpleName}. It is also possible that you changed module " +
                "name and in that case update the mapping as well.")
        }
    }
}

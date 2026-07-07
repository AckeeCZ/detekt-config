package core.ktlint

// Violates ktlint/PropertyWrapping: a property whose initializer pushes the declaration past the line length.
// core.yml raises the rule's maxLineLength to 150.
class PropertyWrapping {
    val wrappedValues = listOf("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx")
}

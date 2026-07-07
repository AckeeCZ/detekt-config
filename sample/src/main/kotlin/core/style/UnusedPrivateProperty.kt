package core.style

import core.Preview

// Violates style/UnusedPrivateProperty (an unused private property).
// core.yml ignores properties annotated @Preview, so this passes once applied.
class UnusedPrivateProperty {
    @Preview
    private val unusedPreviewProperty = "value"
}

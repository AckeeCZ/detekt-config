package core.style

import core.Preview

// Violates style/UnusedPrivateFunction (an unused private function).
// core.yml ignores functions annotated @Preview, so this passes once applied.
class UnusedPrivateFunction {
    @Preview
    private fun unusedPreviewFunction() {
        println("preview")
    }
}

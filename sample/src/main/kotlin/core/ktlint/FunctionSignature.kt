package core.ktlint

// Violates ktlint/FunctionSignature: a single-line function signature exceeding the line length.
// core.yml raises the rule's maxLineLength to 150.
class FunctionSignature {
    fun buildSignature(parameterAlpha: String, parameterBravoxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx: String) {
        println(parameterAlpha + parameterBravoxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx)
    }
}

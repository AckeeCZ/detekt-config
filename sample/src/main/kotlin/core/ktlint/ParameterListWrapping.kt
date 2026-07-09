package core.ktlint

// Violates ktlint/ParameterListWrapping: a parameter list that exceeds the line length on one line.
// core.yml raises the rule's maxLineLength to 150 (co-triggers FunctionSignature, also 150).
class ParameterListWrapping {
    fun wrapParameterList(alpha: String, bravo: String, charliexxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx: String) {
        println(alpha + bravo + charliexxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx)
    }
}

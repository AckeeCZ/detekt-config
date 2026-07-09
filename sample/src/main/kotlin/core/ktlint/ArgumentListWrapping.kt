package core.ktlint

// Violates ktlint/ArgumentListWrapping: a call whose argument list exceeds the line length on one line.
// core.yml raises the rule's maxLineLength to 150 (co-triggers PropertyWrapping / line-length rules, all 150).
class ArgumentListWrapping {
    val values = listOf("alpha", "bravo", "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx")
}

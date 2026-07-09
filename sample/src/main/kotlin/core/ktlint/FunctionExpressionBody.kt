package core.ktlint

// Violates ktlint/FunctionExpressionBody: a block body with a single return (should be an expression body).
// core.yml disables the rule (active: false), so this passes once applied.
fun functionExpressionBody(value: String): String {
    return value.uppercase()
}

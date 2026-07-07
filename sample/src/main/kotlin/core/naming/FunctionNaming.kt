package core.naming

import core.Composable

// Violates naming/FunctionNaming (functionPattern requires a lowercase first letter).
// core.yml ignores functions annotated @Composable, so this Composable-style name passes once applied.
@Composable
fun FunctionNaming() {
    println("composable")
}

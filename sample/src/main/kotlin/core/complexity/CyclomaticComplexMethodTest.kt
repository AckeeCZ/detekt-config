package core.complexity

// Violates complexity/CyclomaticComplexMethod (allowedComplexity 14 by default). This file is
// named `*Test.kt`, which core.yml adds to the rule's `excludes`, so it is skipped once applied.
// Detekt's default excludes are path-based (`**/test/**`), so this main-source file is analysed by default.
fun cyclomaticComplexMethod(value: String) {
    when (value) {
        "a" -> println("a")
        "b" -> println("b")
        "c" -> println("c")
        "d" -> println("d")
        "e" -> println("e")
        "f" -> println("f")
        "g" -> println("g")
        "h" -> println("h")
        "i" -> println("i")
        "j" -> println("j")
        "k" -> println("k")
        "l" -> println("l")
        "m" -> println("m")
        "n" -> println("n")
        "o" -> println("o")
        "p" -> println("p")
        else -> println("else")
    }
}

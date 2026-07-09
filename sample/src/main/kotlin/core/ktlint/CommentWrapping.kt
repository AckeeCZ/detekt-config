package core.ktlint

// Violates ktlint/CommentWrapping: a block comment sharing its line with code.
// core.yml disables the rule (active: false), so this passes once applied.
/* block comment */ fun commentWrapping() = println("body")

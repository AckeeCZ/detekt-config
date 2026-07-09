package core.style

// Violates style/AbstractClassCanBeInterface (abstract class with only abstract members).
// core.yml disables the rule (active: false), so this passes once applied.
abstract class AbstractClassCanBeInterface {
    abstract fun abstractMethod()
}

package core.style

// Violates style/AbstractClassCanBeConcreteClass (abstract class with no abstract members).
// core.yml disables the rule (active: false), so this passes once applied.
abstract class AbstractClassCanBeConcreteClass {
    fun concreteMethod() {
        println("concrete")
    }
}

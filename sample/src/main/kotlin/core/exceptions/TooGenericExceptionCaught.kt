package core.exceptions

// Violates exceptions/TooGenericExceptionCaught (active by default): catching Throwable.
// core.yml disables the rule (active: false), so this passes once the config is applied.
fun tooGenericExceptionCaught() {
    try {
        println("body")
    } catch (throwable: Throwable) {
        println(throwable)
    }
}

package core.style

// Violates style/MaxLineLength (maxLineLength 120 by default; core.yml raises it to 150).
// The line below is 135 characters. It also co-triggers ktlint/MaximumLineLength (also 150).
class MaxLineLength {
    val maxLineLengthProperty = "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx"
}

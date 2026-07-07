package core.ktlint

// Violates ktlint/MaximumLineLength (maxLineLength 120 by default; core.yml raises it to 150).
// The line below is 135 characters. It also co-triggers style/MaxLineLength (also 150).
class MaximumLineLength {
    val maximumLineLengthProperty = "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx"
}

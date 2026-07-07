package core.complexity

import core.Composable

// Violates complexity/LongParameterList (allowedFunctionParameters 5 by default) with 6 parameters.
// core.yml ignores functions annotated @Composable / @TestDataFactory, so this passes once applied.
@Composable
fun longParameterList(first: Int, second: Int, third: Int, fourth: Int, fifth: Int, sixth: Int) {
    println(first + second + third + fourth + fifth + sixth)
}

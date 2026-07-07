package core

// Minimal stand-ins for the annotations referenced by core.yml `ignoreAnnotated` options
// (Compose's @Composable / @Preview and our own @TestDataFactory). Detekt matches
// `ignoreAnnotated` by the annotation's simple name, so these local declarations suffice
// and keep the sample free of a Compose dependency.

annotation class Composable

annotation class Preview

annotation class TestDataFactory

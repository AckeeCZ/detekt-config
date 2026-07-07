# Changelog

All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.1.0/), and this project adheres
to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

## [Unreleased]
### core
#### Changed
- Migrated the config to Detekt `2.0.0-alpha.5` (from `1.23.8`). This is a breaking change and the config now
  requires Detekt 2.0.
  - Renamed the `formatting` rule set to `ktlint`, following the Detekt 2.0 rename of the ktlint wrapper rule set.
  - Replaced the removed `UnnecessaryAbstractClass` rule (disabled) with its successors `AbstractClassCanBeConcreteClass`
    and `AbstractClassCanBeInterface`, both disabled to preserve the original behaviour.
  - Replaced the removed `UnusedPrivateMember` rule with its successors `UnusedPrivateFunction` and
    `UnusedPrivateProperty`, keeping the `Preview` annotation ignored on both.

## [1.0.1] - 2025-11-24
### core
#### Added
- Regexes to exclude more types of test files (`'**Tests.kt'`, `'**TestSuite.kt'`) from `LongMethod` and `CyclomaticComplexMethod` rules.

## [1.0.0] - 2025-09-16
### core
#### Added
- First version of core config file. Configured against Detekt 1.23.8.

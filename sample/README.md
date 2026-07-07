# Sample / config test harness

This module verifies that the shared Detekt configs actually take effect. Every rule that a config
file customises has a matching Kotlin file here that **deliberately violates that rule**:

- **Without** the Ackee config, Detekt reports the violation → the run fails.
- **With** the config applied, the rule is disabled / reconfigured / ignored → the run passes.

If Detekt fails while the config is applied, the config is not doing what it claims.

## Layout

Sources live under `src/main/kotlin/<config-module>/<rule-group>/<Rule>.kt` — one top-level package per
config module (currently only [`core`](../core/core.yml), room for more later), then a subpackage per Detekt
rule group, then one file per rule:

```
src/main/kotlin/core/
├── TestAnnotations.kt                     # @Composable / @Preview / @TestDataFactory stand-ins (no Compose dep)
├── complexity/
│   ├── CyclomaticComplexMethodTest.kt     # excludes: '**Test.kt' (note the file name)
│   ├── LongMethod.kt                      # ignoreAnnotated: @TestDataFactory
│   ├── LongParameterList.kt               # ignoreAnnotated: @Composable
│   └── TooManyFunctions.kt                # active: false
├── exceptions/
│   └── TooGenericExceptionCaught.kt       # active: false
├── ktlint/
│   ├── ArgumentListWrapping.kt            # maxLineLength: 150
│   ├── CommentWrapping.kt                 # active: false
│   ├── FunctionSignature.kt               # maxLineLength: 150
│   ├── MaximumLineLength.kt               # maxLineLength: 150
│   ├── ParameterListWrapping.kt           # maxLineLength: 150
│   ├── ParameterWrapping.kt               # maxLineLength: 150
│   └── PropertyWrapping.kt                # maxLineLength: 150
├── naming/
│   └── FunctionNaming.kt                  # ignoreAnnotated: @Composable
└── style/
    ├── AbstractClassCanBeConcreteClass.kt # active: false
    ├── AbstractClassCanBeInterface.kt     # active: false
    ├── MaxLineLength.kt                    # maxLineLength: 150
    ├── UnusedPrivateFunction.kt           # ignoreAnnotated: @Preview
    └── UnusedPrivateProperty.kt           # ignoreAnnotated: @Preview
```

Each file is crafted to trip **only** rules that the config neutralises, so a passing run with the config
applied is meaningful (nothing else leaks through).

## Running it

Use **`detektMain`**, not the plain `detekt` task. Five of the covered rules (`LongParameterList`,
`AbstractClassCanBeConcreteClass`, `AbstractClassCanBeInterface`, `UnusedPrivateFunction`,
`UnusedPrivateProperty`) require **type resolution**, which only the `detektMain` task performs; the lite
`detekt` task silently skips them.

```bash
# 1. Publish the config you want to test to Maven Local
./gradlew :core:publishToMavenLocal

# 2. Baseline: without the config the run fails on all covered rules
./gradlew :sample:detektMain

# 3. Apply the config: uncomment the detektConfig(...) dependency in sample/build.gradle.kts,
#    then re-run — it should now pass
./gradlew :sample:detektMain
```

## Configs intentionally **not** covered

Four `core.yml` entries cannot be exercised with the fail-without / pass-with pattern and are deliberately
left untested:

| Config | Why it can't be tested this way |
| --- | --- |
| `ktlint/ParameterListSpacing` (`maxLineLength`) | A pure spacing rule — its violations are not gated by line length, so raising `maxLineLength` to 150 changes nothing observable. |
| `ktlint/FunctionReturnTypeSpacing` (`maxLineLength`) | Same — a spacing rule, not length-gated. |
| `ktlint/Wrapping` (`maxLineLength`) | Long constructs in the 121–150 window trigger sibling rules (`ClassSignature`, `BinaryExpressionWrapping`) instead of `Wrapping`; there is no clean length-gated trigger. |
| `ktlint/ContextReceiverMapping` (`maxLineLength`) | Requires context receivers (a `-Xcontext-receivers` compiler flag), out of scope for this sample. |

Two further entries that only restated Detekt 2.0 defaults (`comments/AbsentOrWrongFileLicense` and
`style/MagicNumber`) were removed from `core.yml` — see the [CHANGELOG](../CHANGELOG.md).

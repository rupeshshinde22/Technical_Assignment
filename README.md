# Technical Assignment

Spring Boot + Kotlin REST API located in `product-management-api/`.

## Prerequisites

- **JDK 21** (Temurin 21 recommended)
- Gradle wrapper is included — no separate Gradle install needed

Verify:

```bash
java -version   # should print 21.x
```

## Build

```bash
cd product-management-api
./gradlew clean build
```

## Run

```bash
cd product-management-api
./gradlew bootRun
```

The app starts on <http://localhost:8080>.

## Tech stack

| Component | Version |
| --- | --- |
| Gradle | 9.5.1 |
| Kotlin | 2.3.20 |
| Spring Boot | 4.1.0 |
| Java toolchain | 21 |

## Troubleshooting

### VS Code shows `INLINE_FROM_HIGHER_PLATFORM` or `INCOMPATIBLE_CLASS`

These are **false positives**, not real build failures.

The VS Code Kotlin extension bundles its own Kotlin compiler (2.1.0) that
defaults to JVM target 1.8 and cannot read the Gradle model. It therefore
cannot understand code compiled against Kotlin 2.3.20 / JVM 21.

`./gradlew build` is the source of truth. If it prints `BUILD SUCCESSFUL`,
your code is correct.

The bundled `.vscode/settings.json` disables those diagnostics:

```json
{
  "kotlin.languageServer.enabled": false,
  "kotlin.debugAdapter.enabled": false
}
```

### Recommended IDE

IntelliJ IDEA Community imports the Gradle model correctly and does not
show these errors:

```bash
brew install --cask intellij-idea-ce
```

After opening the project, set **Settings → Build Tools → Gradle → Gradle JVM = 21**.

### Clean rebuild

```bash
cd product-management-api
./gradlew --stop
rm -rf .gradle build
./gradlew clean build --refresh-dependencies
```

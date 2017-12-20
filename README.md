# VersionKontrol

## Kotlin Version Checker

A tiny Kotlin library to determine if a version string is newer when compared to another.

Example

```kotlin
import uk.co.edgeorgedev.versionkontrol.VersionKontrol.Companion.isNewerVersion

fun main(args: Array<String>) {

    // The current version
    val myCurrentVersion = "1.0.0"

    // The updated version
    val myUpdatedVersion = "1.0.1"

    if (isNewerVersion(myCurrentVersion, myUpdatedVersion)) {
        // Let user know an update is available or similar action
    }
}

```

## Why & when should I use this?

This library is especially helpful in checking if an application requires a force upgrade/update e.g. when a user's current version contains breaking changes

## Advanced usage

The library currently uses `\\.` as the default delimiter within a version string, although this can be changed easily


```kotlin
import uk.co.edgeorgedev.versionkontrol.VersionKontrol.Companion.isNewerVersion

fun main(args: Array<String>) {

    // The current version
    val myCurrentVersion = "1-0-0"

    // The updated version
    val myUpdatedVersion = "1-0-1"

    if (isNewerVersion(myCurrentVersion, myUpdatedVersion, delimiter = "-")) {
        // Let user know an update is available or similar action
    }
}
```

**Please note, the custom delimiter string is converted to a regular expression**

## Contributing

I welcome contributions and discussion for new features or bug fixes. It is recommended to file an issue first to prevent unnecessary efforts, but feel free to put in pull requests in the case of trivial changes. In any other case, please feel free to open discussion and I will get back to you when possible.
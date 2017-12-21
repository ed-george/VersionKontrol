package uk.co.edgeorgedev.versionkontrol.examples

import uk.co.edgeorgedev.versionkontrol.VersionKontrol.isNewerVersion

fun main(args: Array<String>) {

    // Change these examples at your leisure
    "1.0.0".compareAsVersion("1.0.1")
    "1.0.1".compareAsVersion("1.0.1")
    "2.0.0".compareAsVersion("1.2.3.4")
    "2.0".compareAsVersion("1.2.3.4")
    "1.2.3.4".compareAsVersion("2.0")
    "1.0".compareAsVersion("x.y.z")
    "1-0-0".compareAsVersion("2-0-0", delimiter = "-")

}

// Helper extension method for String
fun String.compareAsVersion(compareWith: String?, delimiter: String? = null) {
    if (isNewerVersion(this, compareWith, delimiter)) {
        println("$compareWith is newer than $this")
    } else {
        println("$compareWith is not newer $this")
    }
}


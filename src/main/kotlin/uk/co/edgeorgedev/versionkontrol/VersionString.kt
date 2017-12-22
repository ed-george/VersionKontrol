package uk.co.edgeorgedev.versionkontrol

/**
 * Extension method for `String` to convert easily to a `VersionCode`
 * @param delimiter optional delimiter, by default the VersionCode.DEFAULT_DELIMITER is used
 */
fun String.toVersionCode(delimiter: String = VersionCode.DEFAULT_DELIMITER): VersionCode {
    return VersionCode(this, delimiter)
}

/**
 * Extension method for `String` to compare with another supplied `String`
 * to determine if the original String is newer when both are converted to `VersionCode` objects
 * @param comparedVersion the `String` to compare as a `VersionCode`
 * @param delimiter optional delimiter, by default the VersionCode.DEFAULT_DELIMITER is used
 */
fun String.isNewerVersionThan(comparedVersion: String, delimiter: String = VersionCode.DEFAULT_DELIMITER): Boolean {
    return VersionCode(this, delimiter) > comparedVersion.toVersionCode(delimiter)
}

/**
 * Extension method for `String` to compare with another supplied `String`
 * to determine if the original String is older when both are converted to `VersionCode` objects
 * @param comparedVersion the `String` to compare as a `VersionCode`
 * @param delimiter optional delimiter, by default the VersionCode.DEFAULT_DELIMITER is used
 */
fun String.isOlderVersionThan(comparedVersion: String, delimiter: String = VersionCode.DEFAULT_DELIMITER): Boolean {
    return VersionCode(this, delimiter) < comparedVersion.toVersionCode(delimiter)
}

/**
 * Extension method for `String` to compare with another supplied `String`
 * to determine if the original String is the same when both are converted to `VersionCode` objects
 * @param currentVersion the `String` to compare as a `VersionCode`
 * @param delimiter optional delimiter, by default the VersionCode.DEFAULT_DELIMITER is used
 */
fun String.isCurrentVersion(currentVersion: String, delimiter: String = VersionCode.DEFAULT_DELIMITER): Boolean {
    return VersionCode(this, delimiter) == currentVersion.toVersionCode(delimiter)
}

/**
 * Safely convert a `String` to an `Int`. Uses the [default] value as a fallback if conversion fails.
 * By default this is 0
 */
fun String.toSafeInt(default: Int = 0): Int {
    return try {
        Integer.parseInt(this)
    } catch (ex: NumberFormatException) {
        default
    }
}

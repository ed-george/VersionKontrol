package uk.co.edgeorgedev.versionkontrol

import java.util.*

/**
 * A class to represent a version code
 *
 * The version code is determined from the [rawValue] string and split using the [delimiter] value which defaults
 * to the punctuation character regular expression class
 *
 * @author Ed George (breedrapps@gmail.com)
 * @since 0.1.0
 */
class VersionCode(rawValue: String, delimiter: String = VersionCode.DEFAULT_DELIMITER): Comparable<VersionCode> {

    companion object {
        // By default use the Punctuation character class as the version delimiter
        // This includes common version code characters such as '.' or '-'
        val DEFAULT_DELIMITER = "\\p{Punct}+"
    }

    // Private version code split by the provided delimiter as a RegEx
    private val splitVersion: Array<String> = rawValue.split(delimiter.toRegex()).dropLastWhile({ it.isEmpty() }).toTypedArray()

    override fun equals(other: Any?): Boolean {
        return when (other) {
            // If supplied type is a VersionCode, directly compare
            is VersionCode -> this.compareTo(other) == 0
            // If supplied type is a String, compare after conversion
            is String -> this.compareTo(VersionCode(other)) == 0
            // Otherwise, equality is false
            else -> false
        }
    }

    override fun compareTo(other: VersionCode): Int {
        // Access split version array from compared version code
        val comparedVersionSplit = other.splitVersion

        // Determine length of largest version code in terms of the number of splits
        val maxVersionLength = Math.max(splitVersion.size, comparedVersionSplit.size)

        // Iterate over the split version code arrays up-to the max length
        for (index in 0 until maxVersionLength) {

            // Check if current index is greater than or equal to relevant array's size. If true, use 0 as current int
            // If false, attempt to convert the current split's index String to an int. If this conversion fails,
            // it falls back to 0.

            // TODO: Check if this fallback to 0 produces undesirable results when comparing 'invalid' version codes
            val originalVersionInt: Int = if (index >= this.splitVersion.size) 0 else splitVersion[index].toSafeInt()
            val comparedVersionInt: Int = if (index >= comparedVersionSplit.size) 0 else comparedVersionSplit[index].toSafeInt()

            // If the int being compared is GT the original then the version being compared is greater
            if (comparedVersionInt > originalVersionInt) {
                return -1
            } else if (originalVersionInt > comparedVersionInt) {
                // If the int of the original is GT the compared int then the version being compared is lower
                return 1
            }
            // If the numbers were the same, continue loop
        }
        // Version codes compared are equal
        return 0
    }

    override fun hashCode(): Int {
        return Arrays.hashCode(splitVersion)
    }

    override fun toString(): String {
        // Re-write version using . as separator
        return splitVersion.joinToString(separator = ".")
    }

}
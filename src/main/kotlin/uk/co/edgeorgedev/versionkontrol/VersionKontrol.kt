package uk.co.edgeorgedev.versionkontrol

object VersionKontrol {

    // Default delimiter is a '.'
    private val DELIMITER = "\\."

    /**
     * Test if a version string is newer than another.
     *
     * @since 0.1
     *
     * @param originalVersion the original version string.
     * @param comparedVersion the version string to compare to the original.
     * @param delimiter the delimiter used between major/minor/etc integers in the version string. Defaults to '.'
     *
     * @return true if comparedVersion is newer; false otherwise
     */
    fun isNewerVersion(originalVersion: String?, comparedVersion: String?, delimiter: String? = DELIMITER): Boolean {

        // If either entered strings are null - return false
        if (originalVersion == null || comparedVersion == null) return false

        // Ensure default delimiter is used if null
        val safeDelimiter = delimiter ?: DELIMITER

        // Split version string on delimiter
        // e.g. "1.2.3" -> ["1", "2", "3"]
        val originalVersionSplit = originalVersion.split(safeDelimiter.toRegex()).dropLastWhile({ it.isEmpty() }).toTypedArray()
        val comparedVersionSplit = comparedVersion.split(safeDelimiter.toRegex()).dropLastWhile({ it.isEmpty() }).toTypedArray()

        // Determine length of largest version code in terms of decimal places
        val maxVersionLength = Math.max(originalVersionSplit.size, comparedVersionSplit.size)

        // Iterate over the split version code arrays up-to the max length
        for (index in 0 until maxVersionLength) {

            val originalVersionInt: Int
            val comparedVersionInt: Int

            try {
                // Get string for current decimal place - This should be nil if the current index is GTE to the number
                // of elements in the relevant split array.
                originalVersionInt = if (index >= originalVersionSplit.size) 0 else Integer.parseInt(originalVersionSplit[index])
                comparedVersionInt = if (index >= comparedVersionSplit.size) 0 else Integer.parseInt(comparedVersionSplit[index])

                // If the int being compared is GT the original then the version being compared is greater
                if (comparedVersionInt > originalVersionInt) {
                    return true
                } else if (originalVersionInt > comparedVersionInt) {
                    return false
                }// If the int of the original is GT the compared int then the version being compared is lower

            } catch (ex: NumberFormatException) {
                // If either the original or compared string is NOT all digits, an invalid version has been entered
                // in this case, the method should return false
                return false
            }

            // If the numbers were the same, continue loop
        }
        // If versions were the same - return false
        return false
    }
}
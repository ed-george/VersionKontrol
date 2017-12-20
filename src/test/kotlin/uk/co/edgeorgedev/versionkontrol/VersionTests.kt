package uk.co.edgeorgedev.versionkontrol

import uk.co.edgeorgedev.versionkontrol.VersionKontrol.Companion.isNewerVersion

import org.junit.Assert.assertThat
import org.junit.Test
import org.hamcrest.core.Is.`is` as isEqual

class VersionTests {
    @Test
    fun testBasicNewerVersionTrue() {
        assertThat(isNewerVersion("8.7.0", "8.7.1"), isEqual(true))
    }

    @Test
    fun testAdvancedNewerVersionTrue() {
        assertThat(isNewerVersion("8.7.0.0", "8.7.1"), isEqual(true))
    }

    @Test
    fun testAdvancedNewerVersionTrueHigher() {
        assertThat(isNewerVersion("8.7.0.1", "8.7.1"), isEqual(true))
    }

    @Test
    fun testEqualFalse() {
        assertThat(isNewerVersion("8.7.0", "8.7.0"), isEqual(false))
    }

    @Test
    fun testBasicLowerComparedFalse() {
        assertThat(isNewerVersion("8.7.1", "8.7.0"), isEqual(false))
    }

    @Test
    fun testDelimiter() {
        assertThat(isNewerVersion("1-0-0", "2-0-0", delimiter = "-"), isEqual(true))
    }

    @Test
    fun testDelimiterFalse() {
        assertThat(isNewerVersion("2-0-0", "1-0-0", delimiter = "-"), isEqual(false))
    }

    @Test
    fun testDelimiterNull() {
        assertThat(isNewerVersion("1.0.0", "2.0.0", delimiter = null), isEqual(true))
    }

    @Test
    fun testDelimiterNullFalse() {
        assertThat(isNewerVersion("2.0.0", "1.0.0", delimiter = null), isEqual(false))
    }

    @Test
    fun testAdvancedLowerComparedFalse() {
        assertThat(isNewerVersion("8.7.1", "8.7.0.0"), isEqual(false))
    }

    @Test
    fun testAdvancedLowerComparedFalseEndHigher() {
        assertThat(isNewerVersion("8.7.1", "8.7.0.1"), isEqual(false))
    }

    @Test
    fun testInvalidSuppliedVersionFalse() {
        assertThat(isNewerVersion("8.7.0", "x.y.z"), isEqual(false))
    }

    @Test
    fun testInvalidOriginalVersionFalse() {
        assertThat(isNewerVersion("x.y.z", "8.7.0"), isEqual(false))
    }

    @Test
    fun testEmpty() {
        assertThat(isNewerVersion("", ""), isEqual(false))
    }

    @Test
    fun testNull() {
        assertThat(isNewerVersion(null, null), isEqual(false))
    }
}
package uk.co.edgeorgedev.versionkontrol

import org.junit.Assert.assertThat
import org.junit.Test
import org.hamcrest.core.Is.`is` as isEqual

class VersionStringTests {

    @Test
    fun testBasicNewerVersionTrue() {
        assertThat("1.2.3".isNewerVersionThan("1.2.2"), isEqual(true))
    }

    @Test
    fun testBasicNewerVersionFalse() {
        assertThat("1.2.3".isNewerVersionThan("3.2.1"), isEqual(false))
    }

    @Test
    fun testBasicNewerEqualsFalse() {
        assertThat("1.2.3".isNewerVersionThan("1.2.3"), isEqual(false))
    }

    @Test
    fun testBasicOlderVersion() {
        assertThat("1.2.3".isOlderVersionThan("3.2.1"), isEqual(true))
    }

    @Test
    fun testBasicOlderVersionFalse() {
        assertThat("3.2.1".isOlderVersionThan("1.2.3"), isEqual(false))
    }

    @Test
    fun testBasicOlderEqualsFalse() {
        assertThat("1.2.3".isOlderVersionThan("1.2.3"), isEqual(false))
    }

    @Test
    fun testAdvancedOlderTrue() {
        assertThat("1x2x3".isOlderVersionThan("3x2x1", delimiter = "x"), isEqual(true))
    }

    @Test
    fun testAdvancedOlderFalse() {
        assertThat("3x2x1".isOlderVersionThan("1x2x3", delimiter = "x"), isEqual(false))
    }

    @Test
    fun testAdvancedNewerTrue() {
        assertThat("3x2x1".isNewerVersionThan("1x2x3", delimiter = "x"), isEqual(true))
    }

    @Test
    fun testAdvancedNewerFalse() {
        assertThat("1x2x3".isNewerVersionThan("3x2x1", delimiter = "x"), isEqual(false))
    }

    @Test
    fun testCurrentVersion() {
        assertThat("1.0.0".isCurrentVersion("1.0.0"), isEqual(true))
    }

    @Test
    fun testCurrentVersionFalse() {
        assertThat("1.0.0".isCurrentVersion("1.0.1"), isEqual(false))
    }

    @Test
    fun testCurrentVersionAdvanced() {
        assertThat("1x0x0".isCurrentVersion("1x0x0", delimiter = "x"), isEqual(true))
    }

    @Test
    fun testCurrentVersionFalseAdvanced() {
        assertThat("1x0x0".isCurrentVersion("1x0x1", delimiter = "x"), isEqual(false))
    }

}
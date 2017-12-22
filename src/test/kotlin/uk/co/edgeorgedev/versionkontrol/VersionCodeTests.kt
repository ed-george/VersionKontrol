
package uk.co.edgeorgedev.versionkontrol

import org.junit.Assert.assertThat
import org.junit.Test
import org.hamcrest.core.Is.`is` as isEqual

class VersionCodeTests {

    // Greater Than / Greater Than Equal

    @Test
    fun testGT() {
        assertThat("1.0.0".toVersionCode() > "0.0.1".toVersionCode(), isEqual(true))
    }

    @Test
    fun testGTFail() {
        assertThat("0.0.1".toVersionCode() > "1.0.0".toVersionCode(), isEqual(false))
    }

    @Test
    fun testGTE() {
        assertThat("1.0.0".toVersionCode() >= "1.0.0".toVersionCode(), isEqual(true))
    }

    @Test
    fun testGTEFail() {
        assertThat("1.0.0".toVersionCode() >= "1.1.0".toVersionCode(), isEqual(false))
    }

    // Less Than / Less Than Equal

    @Test
    fun testLT() {
        assertThat("0.0.1".toVersionCode() < "1.0.0".toVersionCode(), isEqual(true))
    }

    @Test
    fun testLTFail() {
        assertThat("1.0.0".toVersionCode() < "0.0.1".toVersionCode(), isEqual(false))
    }

    @Test
    fun testLTE() {
        assertThat("1.0.0".toVersionCode() <= "1.0.0".toVersionCode(), isEqual(true))
    }

    @Test
    fun testLTEFail() {
        assertThat("1.1.0".toVersionCode() <= "1.0.0".toVersionCode(), isEqual(false))
    }

    // Equality

    @Test
    fun testEquality() {
        assertThat("1.0.0".toVersionCode() == "1.0.0".toVersionCode(), isEqual(true))
    }

    @Test
    fun testEqualityFail() {
        assertThat("1.1.0".toVersionCode() == "1.0.0".toVersionCode(), isEqual(false))
    }

    @Test
    fun testNegEquality() {
        assertThat("1.0.0".toVersionCode() != "1.1.0".toVersionCode(), isEqual(true))
    }

    @Test
    fun testNegEqualityFail() {
        assertThat("1.0.0".toVersionCode() != "1.0.0".toVersionCode(), isEqual(false))
    }

    // Delimiter

    @Test
    fun testEqualityDelimiter() {
        assertThat("1x0x0".toVersionCode("x") == "1x0x0".toVersionCode("x"), isEqual(true))
    }

    @Test
    fun testNegEqualityDelimiter() {
        assertThat("1x0x0".toVersionCode("x") != "1x1x0".toVersionCode("x"), isEqual(true))
    }

}
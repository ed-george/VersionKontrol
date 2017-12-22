package uk.co.edgeorgedev.versionkontrol.examples

import uk.co.edgeorgedev.versionkontrol.isCurrentVersion
import uk.co.edgeorgedev.versionkontrol.isNewerVersionThan
import uk.co.edgeorgedev.versionkontrol.isOlderVersionThan
import uk.co.edgeorgedev.versionkontrol.toVersionCode
import kotlin.io.println as eval

fun main(args: Array<String>) {

   // Basic Example
   val exampleVersion = "1.0.2".toVersionCode()
   val exampleNewVersion = "1.1.0".toVersionCode()

   // Comparable using standard ==, !=, <, >, <=, >= operators
   eval ( exampleNewVersion > exampleVersion )
   eval ( exampleNewVersion )

   // Custom delimiters can be supplied
   val exampleAdvancedVersion = "1x0x2".toVersionCode(delimiter = "x")
   val exampleAdvancedNewVersion = "1a1b0c1".toVersionCode(delimiter = "[abc]")

   eval ( exampleAdvancedNewVersion > exampleAdvancedVersion )
   eval ( exampleAdvancedNewVersion )

   // Helper String extensions are available
   val rawVersionString = "2.3.1"
   val rawVersionOlderString = "2.3.0"

   // Easily check if a version string is older/newer than another
   eval( rawVersionOlderString.isOlderVersionThan(rawVersionString) )
   eval( rawVersionString.isNewerVersionThan(rawVersionOlderString) )

   // Or check a version String is equal using String.isCurrentVersion
   val rawVersionOlderComparisonString = "2.3.0"
   eval( rawVersionOlderString.isCurrentVersion(rawVersionOlderComparisonString) )

}


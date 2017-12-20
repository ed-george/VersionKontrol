Release Process
===============

 1.  Ensure all unit tests are passed and project compiles.
 2.  Ensure `VERSION_NAME` in `gradle.properties` is set to the version you want to release.
 3.  Update `README.md` with the version about to be released.
 4.  Commit: `git commit -am "Prepare version X.Y.X"`
 5.  Tag: `git tag -a X.Y.Z -m "Version X.Y.Z"`
 6.  Update `VERSION_NAME` in `gradle.properties` to the next development version. For example, if
     you just tagged version 1.0.0 you would set this value to 1.0.1 - Do NOT append "-SNAPSHOT" to
     this value, it will be added automatically.
 7.  Commit: `git commit -am "Prepare next development version."`
 8.  Push: `git push && git push --tags`
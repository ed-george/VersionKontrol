#!/bin/bash
# This script will build the project.

echo -e 'Build Branch for Release => Branch ['$TRAVIS_BRANCH']  Tag ['$TRAVIS_TAG']'
./gradlew -Prelease.travisci=true -Prelease.useLastTag=true

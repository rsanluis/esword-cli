#!/usr/bin/env bash

[ ! -e "kjv+matches.bbli" ] && ./install-kjv+matches-bible.sh
./gradlew clean build "-Dorg.gradle.jvmargs=--enable-native-access=ALL-UNNAMED"

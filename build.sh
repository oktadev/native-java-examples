#!/usr/bin/env bash

# exit when any command fails
set -e

rm -rf {helidon,micronaut,quarkus,spring-boot}/target

cd micronaut && ./mvnw package -Dpackaging=native-image

cd ../quarkus && ./mvnw package -Pnative

cd ../spring-boot && ./mvnw package -Pnative

cd ../helidon && mvn package -Pnative-image

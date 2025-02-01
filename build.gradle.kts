plugins {
    `java-library`
    `maven-publish`
}

group = "studio.o7"

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.google.code.gson:gson:2.11.0")
}

java {
    withSourcesJar()
    withJavadocJar()
}
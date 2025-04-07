plugins {
    `java-library`
    `maven-publish`
}

group = "studio.o7"

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.google.code.gson:gson:2.12.1")
}

java {
    withSourcesJar()
    withJavadocJar()

    sourceCompatibility = JavaVersion.VERSION_23
    targetCompatibility = JavaVersion.VERSION_23
}

publishing {
    publications {
        create<MavenPublication>("mavenJava") {

            groupId = "studio.o7"
            artifactId = "octopus-sdk"
            version = "0.0.1"

            pom {
                name = "octopus-sdk"
                url = "https://github.com/o7studios/octopus-sdk"
                description = "The official o7studios octopus-sdk"

                developers {
                    developer {
                        id = "raphael-goetz"
                        name = "Raphael Goetz"
                    }
                }

                scm {
                    connection = "scm:git:git://github.com/o7studios/octopus-sdk.git"
                    developerConnection = "scm:git:git@https://github.com/o7studios/octopus-sdk.git"
                    url = "https://github.com/o7studios/octopus-sdk"
                    tag = "HEAD"
                }

                ciManagement {
                    system = "GitHub Actions"
                    url = "https://github.com/o7studios/octopus-sdk/actions"
                }
            }
        }
    }

    repositories {
        maven {
            name = "GithubPackages"
            url = uri("https://github.com/o7studios/octopus-sdk")
            credentials {
                username = System.getenv("GITHUB_ACTOR")
                password = System.getenv("GITHUB_TOKEN")
            }
        }
    }
}
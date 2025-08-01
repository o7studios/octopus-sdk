plugins {
    id("studio.o7.remora") version "0.2.5"
    id("com.google.protobuf") version "0.9.5"
}

dependencies {
    compileOnlyApi(libs.bundles.grpc)
    compileOnlyApi(libs.bundles.googleProtobuf)
    compileOnlyApi(libs.javax)
}

sourceSets {
    named("main") {
        java.srcDir("$projectDir/src/generated/java")
    }
}

group = "studio.o7"

information {
    artifactId = "octopus-api"
    description = "Octopus Paper plugin api"
    url = "https://o7.studio"

    developers {
        developer {
            id = "julian-siebert"
            name = "Julian Siebert"
            email = "julian.siebert@o7.studio"
        }
        developer {
            id = "raphael-goetz"
            name = "Raphael Goetz"
            email = "raphael.goetz@o7.studio"
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

    licenses {
        license {
            name = "The Apache Software License, Version 2.0"
            url = "https://www.apache.org/licenses/LICENSE-2.0.txt"
        }
    }
}
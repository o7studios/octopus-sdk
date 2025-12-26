plugins {
    id("studio.o7.remora") version "0.2.9"
}

dependencies {
    api(libs.gson)
    compileOnlyApi(libs.bundles.grpc)
    compileOnlyApi(libs.bundles.googleProtobuf)
    compileOnlyApi(libs.googleProto)
    compileOnlyApi(libs.javax)
}

group = "studio.o7"

information {
    artifactId = "octopus-sdk"
    description = "Octopus Java SDK"
    url = "https://o7.studio"

    developers {
        developer {
            id = "raphael-goetz"
            name = "Konfuzius"
            email = "konfuzius@o7.studio"
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
            name = "GNU General Public License, Version 3"
            url = "https://www.gnu.org/licenses/gpl-3.0.txt"
        }
    }
}
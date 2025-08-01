rootProject.name = "octopus-sdk"

dependencyResolutionManagement {
    versionCatalogs {
        create("libs") {
            version("grpc", "1.73.0")
            version("googleProtobuf", "4.31.1")
            version("javax", "1.3.2")

            library("javax", "javax.annotation", "javax.annotation-api").versionRef("javax")

            library("grpc-okhttp", "io.grpc", "grpc-okhttp").versionRef("grpc")
            library("grpc-protobuf", "io.grpc", "grpc-protobuf").versionRef("grpc")
            library("grpc-stub", "io.grpc", "grpc-stub").versionRef("grpc")
            library("grpc-core", "io.grpc", "grpc-core").versionRef("grpc")
            library("grpc-services", "io.grpc", "grpc-services").versionRef("grpc")

            library("protobuf-java", "com.google.protobuf", "protobuf-java").versionRef("googleProtobuf")
            library("protobuf-java-util", "com.google.protobuf", "protobuf-java-util").versionRef("googleProtobuf")

            bundle("googleProtobuf", listOf(
                "protobuf-java-util",
                "protobuf-java"
            ))

            bundle("grpc", listOf(
                "grpc-okhttp",
                "grpc-core",
                "grpc-protobuf",
                "grpc-stub",
                "grpc-services"
            ))
        }
    }
}

include("sdk:java")
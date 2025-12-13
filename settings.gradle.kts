rootProject.name = "octopus-sdk"

dependencyResolutionManagement {
    versionCatalogs {
        create("libs") {
            version("grpc", "1.77.0")
            version("googleProtobuf", "4.32.0")
            version("googleProto", "2.63.2")
            version("javax", "1.3.2")
            version ("gson", "2.13.1")

            library("javax", "javax.annotation", "javax.annotation-api").versionRef("javax")

            library("grpc-netty", "io.grpc", "grpc-netty").versionRef("grpc")
            library("grpc-protobuf", "io.grpc", "grpc-protobuf").versionRef("grpc")
            library("grpc-stub", "io.grpc", "grpc-stub").versionRef("grpc")
            library("grpc-core", "io.grpc", "grpc-core").versionRef("grpc")
            library("grpc-services", "io.grpc", "grpc-services").versionRef("grpc")

            library("protobuf-java", "com.google.protobuf", "protobuf-java").versionRef("googleProtobuf")
            library("protobuf-java-util", "com.google.protobuf", "protobuf-java-util").versionRef("googleProtobuf")

            library("googleProto", "com.google.api.grpc", "proto-google-common-protos").versionRef("googleProto")

            library("gson", "com.google.code.gson", "gson").versionRef("gson")

            bundle("googleProtobuf", listOf(
                "protobuf-java-util",
                "protobuf-java"
            ))

            bundle("grpc", listOf(
                "grpc-netty",
                "grpc-core",
                "grpc-protobuf",
                "grpc-stub",
                "grpc-services"
            ))
        }
    }
}

include("sdk:java")
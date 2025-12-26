# Octopus API & SDKs

Source protobufs and generated SDKs for the Octopus product.

## What's here

- `proto/` Protocol Buffer definitions (versioned)
- `sdk/` Generated SDKs: Go, Java, TypeScript, and OpenAPI
- `buf.yaml`, `buf.gen.yaml` Buf config for linting and generation

## Requirements

- [Buf](https://buf.build/) for code generation
- `make` (optional) for the helper target

## Generate SDKs

```sh
make generate-proto
```

This removes existing generated output in `sdk/` and regenerates from `proto/` via `buf`.

## Install SDKs

### Go

```sh
go get github.com/o7studios/octopus-sdk/sdk/go@latest
```

### TypeScript / JavaScript

```sh
npm install @o7studios/octopus-sdk
```

### Java

Maven Central:

```kotlin
// build.gradle.kts
dependencies {
    implementation("studio.o7:octopus-sdk:VERSION")
}
```

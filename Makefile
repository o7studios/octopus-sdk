generate-proto::
	rm -rf ./sdk/java/studio && rm -rf ./sdk/go && rm -rf ./sdk/ts/src/gen && rm -rf ./sdk/openapi && buf generate --template buf.gen.yaml
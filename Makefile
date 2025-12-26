generate-proto::
	rm -rf ./sdk/java && rm -rf ./sdk/golang && rm -rf ./sdk/ts/src/gen && rm -rf ./sdk/openapi && buf generate --template buf.gen.yaml
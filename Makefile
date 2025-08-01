generate-proto::
	rm -rf ./sdk/java/src/generated && rm -rf ./sdk/golang/gen && rm -rf ./sdk/js/gen && rm -rf ./sdk/rust/src/gen && buf generate --template buf.gen.yaml
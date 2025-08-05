package structs

import (
	"encoding/json"
	"log"

	"google.golang.org/protobuf/encoding/protojson"
	spb "google.golang.org/protobuf/types/known/structpb"
)

func Serialize(v any) (*spb.Struct, error) {
	jsonBytes, err := json.Marshal(v)
	if err != nil {
		return nil, err
	}

	log.Printf("Serialized %T into JSON: %s\n", v, string(jsonBytes))

	var pbStruct spb.Struct
	err = protojson.Unmarshal(jsonBytes, &pbStruct)
	if err != nil {
		return nil, err
	}
	return &pbStruct, nil
}

func Deserialize[T any](pbStruct *spb.Struct) (*T, error) {
	jsonBytes, err := protojson.Marshal(pbStruct)
	if err != nil {
		return nil, err
	}

	log.Printf("Deserialized Struct into JSON: %s\n", string(jsonBytes))

	var result T
	err = json.Unmarshal(jsonBytes, &result)
	if err != nil {
		return nil, err
	}
	return &result, nil
}

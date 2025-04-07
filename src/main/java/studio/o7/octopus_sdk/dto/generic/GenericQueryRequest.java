package studio.o7.octopus_sdk.dto.generic;

import com.google.gson.JsonObject;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/// Query request for generic object
///
/// @param collection Name of the collection the generic object is stored in
/// @param filter     MongoDB filter as a JSON object. See more on [MongoDB Filter Documentation](https://www.mongodb.com/docs/manual/reference/operator/aggregation/filter/)
public record GenericQueryRequest(@SerializedName("collection") @Expose String collection,
                                  @SerializedName("filter") @Expose JsonObject filter) {
}

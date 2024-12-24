package studio.o7.octopus_sdk.dto.attribute;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import studio.o7.octopus_sdk.adapter.InstantAdapter;


import java.time.Instant;

public record AttributeCreateRequest(@SerializedName("namespace") @Expose String namespace,
                                     @SerializedName("target_id") @Expose String targetId,
                                     @SerializedName("attribute_key") @Expose String attributeKey,
                                     @SerializedName("attribute_value") @Expose String attributeValue,
                                     @SerializedName("expired_at") @Expose @JsonAdapter(InstantAdapter.class) Instant expiredAt) {
}

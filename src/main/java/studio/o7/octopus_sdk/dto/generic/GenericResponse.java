package studio.o7.octopus_sdk.dto.generic;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import studio.o7.octopus_sdk.adapter.InstantAdapter;

import java.time.Instant;

public record GenericResponse<T>(@SerializedName("_id") @Expose String id,
                                 @SerializedName("collection") @Expose String collection,
                                 @SerializedName("namespace") @Expose String namespace,
                                 @SerializedName("target_id") @Expose String targetId,
                                 @SerializedName("body") @Expose T body,
                                 @SerializedName("created_at") @Expose @JsonAdapter(InstantAdapter.class) Instant createdAt,
                                 @SerializedName("expires_at") @Expose @JsonAdapter(InstantAdapter.class) Instant expiresAt) {
}

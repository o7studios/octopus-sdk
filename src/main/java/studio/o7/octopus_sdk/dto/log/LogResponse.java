package studio.o7.octopus_sdk.dto.log;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import studio.o7.octopus_sdk.adapter.InstantAdapter;

import java.time.Instant;

public record LogResponse(@SerializedName("_id") @Expose String id,
                          @SerializedName("namespace") @Expose String namespace,
                          @SerializedName("target_id") @Expose String targetId,
                          @SerializedName("level") @Expose String level,
                          @SerializedName("message") @Expose String message,
                          @SerializedName("created_at") @Expose @JsonAdapter(InstantAdapter.class) Instant createdAt) {
}

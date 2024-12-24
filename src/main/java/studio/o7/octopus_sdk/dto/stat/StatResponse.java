package studio.o7.octopus_sdk.dto.stat;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import studio.o7.octopus_sdk.adapter.InstantAdapter;
import studio.o7.octopus_sdk.dto.ApiRequest;

import java.time.Instant;

public record StatResponse(@SerializedName("_id") @Expose String id,
                           @SerializedName("namespace") @Expose String namespace,
                           @SerializedName("target_id") @Expose String targetId,
                           @SerializedName("stat_key") @Expose String statKey,
                           @SerializedName("stat_value") @Expose Integer statValue,
                           @SerializedName("created_at") @Expose @JsonAdapter(InstantAdapter.class) Instant createdAt,
                           @SerializedName("expired_at") @Expose @JsonAdapter(InstantAdapter.class) Instant expiredAt) {
}

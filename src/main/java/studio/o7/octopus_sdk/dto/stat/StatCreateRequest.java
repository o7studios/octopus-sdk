package studio.o7.octopus_sdk.dto.stat;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import studio.o7.octopus_sdk.adapter.InstantAdapter;

import java.time.Instant;

public record StatCreateRequest(@SerializedName("namespace") @Expose String namespace,
                                @SerializedName("target_id") @Expose String targetId,
                                @SerializedName("stat_key") @Expose String statKey,
                                @SerializedName("stat_value") @Expose Integer statValue,
                                @SerializedName("expired_at") @Expose @JsonAdapter(InstantAdapter.class) Instant expiredAt) {
}

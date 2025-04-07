package studio.o7.octopus_sdk.dto.log;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public record LogCreateRequest(@SerializedName("namespace") @Expose String namespace,
                               @SerializedName("target_id") @Expose String targetId,
                               @SerializedName("level") @Expose String level,
                               @SerializedName("message") @Expose String message,
                               @SerializedName("is_permanent") @Expose Boolean isPermanent,
                               @SerializedName("server_name") @Expose String serverName) {
}

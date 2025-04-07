package studio.o7.octopus_sdk.dto.permission;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import studio.o7.octopus_sdk.adapter.InstantAdapter;

import java.time.Instant;

public record PermissionCreateRequest(@SerializedName("_id") @Expose String namespace,
                                      @SerializedName("target_id") @Expose String targetId,
                                      @SerializedName("permission_node") @Expose String permissionNode,
                                      @SerializedName("permission_value") @Expose String permissionValue,
                                      @SerializedName("permission_priority") @Expose Integer permissionPriority,
                                      @SerializedName("expired_at") @Expose @JsonAdapter(InstantAdapter.class) Instant expiredAt,
                                      @SerializedName("is_permanent") @Expose Boolean isPermanent,
                                      @SerializedName("server_name") @Expose String serverName) {
}

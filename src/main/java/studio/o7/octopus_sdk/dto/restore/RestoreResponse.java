package studio.o7.octopus_sdk.dto.restore;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import studio.o7.octopus_sdk.dto.attribute.AttributeResponse;
import studio.o7.octopus_sdk.dto.log.LogResponse;
import studio.o7.octopus_sdk.dto.permission.PermissionResponse;
import studio.o7.octopus_sdk.dto.stat.StatResponse;

import java.util.List;

public record RestoreResponse(@SerializedName("id") @Expose String Id,
                              @SerializedName("attributes") @Expose List<AttributeResponse> attributes,
                              @SerializedName("logs") @Expose List<LogResponse> logs,
                              @SerializedName("permissions") @Expose List<PermissionResponse> permissions,
                              @SerializedName("stats") @Expose List<StatResponse> stats) {
}

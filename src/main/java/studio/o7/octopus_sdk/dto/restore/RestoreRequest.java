package studio.o7.octopus_sdk.dto.restore;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public record RestoreRequest(@SerializedName("id") @Expose String Id) {
}

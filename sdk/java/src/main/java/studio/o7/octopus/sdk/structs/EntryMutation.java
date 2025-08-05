package studio.o7.octopus.sdk.structs;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.Instant;
import java.util.Locale;

@RequiredArgsConstructor
@Getter
public final class EntryMutation extends ProtoStruct {
    private final MutationType type;
    private final Object data;
    @SerializedName("expired_at")
    private final Instant expiredAt;
    @SerializedName("deleted_at")
    private final Instant deletedAt;

    public enum MutationType {
        CREATE,
        UPDATE,
        DELETE,
        SOFT_DELETE;

        @Override
        public String toString() {
            return name().toLowerCase(Locale.ROOT);
        }
    }
}

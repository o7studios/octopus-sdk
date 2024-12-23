package studio.o7.dto.stat;

import java.util.Date;

public record StatResponse(
        String id,
        String namespace,
        String targetId,
        String statKey,
        Integer statValue,
        Date createdAt,
        Date expiresAt
) {
}

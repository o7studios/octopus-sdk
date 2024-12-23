package studio.o7.dto.stat;

import java.util.Date;

public record StatCreateRequest(
        String namespace,
        String targetId,
        String statKey,
        Integer statValue,
        Date expiresAt
) {
}

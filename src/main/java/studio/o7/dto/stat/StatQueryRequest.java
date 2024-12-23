package studio.o7.dto.stat;

import java.util.Date;

public record StatQueryRequest(
        String namespace,
        String targetId,
        String statKey,
        Integer statValueAbove,
        Integer statValueBelow,
        Date createdAfter,
        Date createdBefore,
        Date expiredAfter,
        Date expiredBefore
) {
}

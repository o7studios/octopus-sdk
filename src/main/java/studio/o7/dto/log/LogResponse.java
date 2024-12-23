package studio.o7.dto.log;

import java.util.Date;

public record LogResponse(
        String id,
        String namespace,
        String targetId,
        String level,
        String message,
        Date createdAt
) {
}

package studio.o7.dto.attribute;

import java.util.Date;

public record AttributeResponse(
        String id,
        String Namespace,
        String targetId,
        String attributeKey,
        String attributeValue,
        Date createdAt,
        Date expiresAt
) {}

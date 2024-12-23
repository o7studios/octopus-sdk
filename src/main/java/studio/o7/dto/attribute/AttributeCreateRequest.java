package studio.o7.dto.attribute;

import java.util.Date;

public record AttributeCreateRequest(
        String namespace,
        String targetId,
        String attributeKey,
        String attributeValue,
        Date expiresAt
) {}

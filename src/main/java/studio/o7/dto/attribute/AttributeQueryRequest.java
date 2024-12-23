package studio.o7.dto.attribute;

import java.util.Date;

public record AttributeQueryRequest(
        String namespace,
        String targetId,
        String attributeKey,
        Date createdAfter,
        Date createdBefore,
        Date expiredAfter,
        Date expiredBefore
) {}

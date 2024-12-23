package studio.o7.dto.permission;

import java.util.Date;

public record PermissionQueryRequest(
        String namespace,
        String targetId,
        String permissionNode,
        Boolean permissionValue,
        Integer priorityAbove,
        Integer priorityBelow,
        Date createdAfter,
        Date createdBefore,
        Date expiresAfter,
        Date expiresBefore
) {
}

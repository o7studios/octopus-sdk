package studio.o7.dto.permission;

import java.util.Date;

public record PermissionResponse(
        String id,
        String namespace,
        String targetId,
        String permissionNode,
        Boolean permissionValue,
        Integer permissionPriority,
        Date createdAt,
        Date expiresAt
) {
}
